package com.f9g4.web.utils;

import org.springframework.ui.ModelMap;

public class ViewAccess {
	
	public ViewAccess()
	{
		
	}
	/**
	 * @param source ModelMap source
	 * @param boardEditAccess Designer edit functions
	 * @param shoppingCart show shopping cart utility
	 * @param viewProfile link to get user profile
	 * @param fileDownload link to download source file
	 * @param viewMainImage link to see original size image in new browser window
	 * @param showBoardStatus publish to marketplace status
	 * @param showRelatedBoards boards in the same portfolio
	 * @param showSuggestBoards boards that suggested from our system
	 * @param approveBoard approve board utility
	 * @return process status
	 */
	public Boolean assignBoardViewerAccess(ModelMap source,
			Boolean boardEditAccess,
			Boolean shoppingCart,
			Boolean viewProfile,
			Boolean fileDownload,
			Boolean viewMainImage,
			Boolean showBoardStatus,
			Boolean showRelatedBoards,
			Boolean showSuggestBoards,
			Boolean approveBoard)
	{
		/*
		access.boardEditAccess
		access.shoppingCart
		access.viewProfile
		access.fileDownload
		access.viewMainImage
		access.showBoardStatus
		access.showRelatedBoards
		access.showSuggestBoards
		*/
		Boolean hasError=false;
		ModelMap accessMap=new ModelMap();
		accessMap.addAttribute("boardEditAccess", boardEditAccess);
		accessMap.addAttribute("shoppingCart", shoppingCart);
		accessMap.addAttribute("viewProfile", viewProfile);
		accessMap.addAttribute("fileDownload", fileDownload);
		accessMap.addAttribute("viewMainImage", viewMainImage);
		accessMap.addAttribute("showBoardStatus", showBoardStatus);
		accessMap.addAttribute("showRelatedBoards", showRelatedBoards);
		accessMap.addAttribute("showSuggestBoards", showSuggestBoards);
		accessMap.addAttribute("approveBoard", approveBoard);
		source.addAttribute("access", accessMap);
		return hasError;
	}
}
