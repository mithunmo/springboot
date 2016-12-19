
/*
 * SpringSourcery - http://www.springsourcery.org
 *
 * Copyright (C) 2011 Dan Macklin.
 *
 * SpringSourcery is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * SpringSourcery is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SpringSourcery; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 */

package com.f9g4.webapp.servicesFacade.impl;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public abstract class DocumentFacadeAbstract {
	
	@Autowired
	@Value("${fileStore}")
	protected String profileLocation;
	
	protected BufferedImage scaleToBufferedImage(long userId, String fileName, int width, int height) {

		File file = new File(profileLocation + "/" + userId + "/pictures/" + fileName);

		byte[] bytes = new byte[(int) file.length()];

		ByteArrayInputStream bis = null;
		FileInputStream fis = null;

		try {
			bis = new ByteArrayInputStream(bytes);

			fis = new FileInputStream(file);

			fis.read(bytes);

			BufferedImage image = ImageIO.read(bis);

			return getScaledInstance(image, width, height, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			try{
				if (fis != null) {
					fis.close();
				}
			}
			catch (Exception e2){
				e2.printStackTrace();
			}
		}

		return null;
	}

	private BufferedImage getScaledInstance(BufferedImage img, int targetWidth, int targetHeight, boolean higherQuality) {
		int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB
				: BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = (BufferedImage) img;
		if (ret.getHeight() < targetHeight || ret.getWidth() < targetWidth) {
			higherQuality = false;
		}
		int w, h;
		if (higherQuality) {
			// Use multi-step technique: start with original size, then
			// scale down in multiple passes with drawImage()
			// until the target size is reached
			w = img.getWidth();
			h = img.getHeight();
		} else {
			// Use one-step technique: scale directly from original
			// size to target size with a single drawImage() call
			w = targetWidth;
			h = targetHeight;
		}

		do {
			if (higherQuality && w > targetWidth) {
				w /= 2;
				if (w < targetWidth) {
					w = targetWidth;
				}
			}

			if (higherQuality && h > targetHeight) {
				h /= 2;
				if (h < targetHeight) {
					h = targetHeight;
				}
			}

			BufferedImage tmp = new BufferedImage(w, h, type);
			Graphics2D g2 = tmp.createGraphics();
			g2.drawImage(ret, 0, 0, w, h, null);
			g2.dispose();

			ret = tmp;
		} while (w != targetWidth || h != targetHeight);

		return ret;
	}
	
	protected BufferedImage cropToBufferedImage(long userId, String fileName, int scaleWidth, int scaleHeight,
			int cropWidth, int cropHeight, int cropStartX, int cropStartY) {

		try {
			BufferedImage croped = scaleToBufferedImage(userId, fileName, scaleWidth, scaleHeight);

			return cropMyImage(croped, cropWidth, cropHeight, cropStartX, cropStartY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private BufferedImage cropMyImage(BufferedImage img, int cropWidth, int cropHeight, int cropStartX, int cropStartY)
			throws Exception {

		BufferedImage clipped = null;

		Dimension size = new Dimension(cropWidth, cropHeight);

		Rectangle clip = createClip(img, size, cropStartX, cropStartY);

		try {
			int w = clip.width;
			int h = clip.height;

			clipped = img.getSubimage(clip.x, clip.y, w, h);
		} catch (RasterFormatException rfe) {
			//System.out.println("Raster format error: " + rfe.getMessage());
			return null;
		}
		return clipped;
	}

	/**
	 * This method crops an original image to the crop parameters provided.
	 * 
	 * If the crop rectangle lies outside the rectangle (even if partially),
	 * adjusts the rectangle to be included within the image area.
	 * 
	 * @param img
	 *            = Original Image To Be Cropped
	 * @param size
	 *            = Crop area rectangle
	 * @param clipX
	 *            = Starting X-position of crop area rectangle
	 * @param clipY
	 *            = Starting Y-position of crop area rectangle
	 * @throws Exception
	 */

	private Rectangle createClip(BufferedImage img, Dimension size, int clipX, int clipY) throws Exception {

		/**
		 * Some times clip area might lie outside the original image, fully or
		 * partially. In such cases, this program will adjust the crop area to
		 * fit within the original image.
		 * 
		 * isClipAreaAdjusted flag is used to denote if there was any adjustment
		 * made.
		 */

		Rectangle clip = null;

		/** Checking for negative X Co-ordinate **/
		if (clipX < 0) {
			clipX = 0;
		}
		/** Checking for negative Y Co-ordinate **/
		if (clipY < 0) {
			clipY = 0;
		}

		/** Checking if the clip area lies outside the rectangle **/
		if ((size.width + clipX) <= img.getWidth() && (size.height + clipY) <= img.getHeight()) {

			/**
			 * Setting up a clip rectangle when clip area lies within the image.
			 */

			clip = new Rectangle(size);
			clip.x = clipX;
			clip.y = clipY;
		} 
		else {

			/**
			 * Checking if the width of the clip area lies outside the image. If
			 * so, making the image width boundary as the clip width.
			 */
			if ((size.width + clipX) > img.getWidth())
				size.width = img.getWidth() - clipX;

			/**
			 * Checking if the height of the clip area lies outside the image.
			 * If so, making the image height boundary as the clip height.
			 */
			if ((size.height + clipY) > img.getHeight())
				size.height = img.getHeight() - clipY;

			/** Setting up the clip are based on our clip area size adjustment **/
			clip = new Rectangle(size);
			clip.x = clipX;
			clip.y = clipY;
		}

		return clip;
	}

	static class JPGFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".JPG") || name.endsWith(".JPEG"));
		}
	}
}
