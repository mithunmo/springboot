package com.f9g4.web.forms;

import java.util.Arrays;

public class SampleForm {

	private Integer[] boardId;
	private String[] filename;
	private String[] filename_ext;
	private String[] filename_400;
	private String[] filename_100;
	private String[] filename_original;
	public Integer[] getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer[] boardId) {
		this.boardId = boardId;
	}
	public String[] getFilename() {
		return filename;
	}
	public void setFilename(String[] filename) {
		this.filename = filename;
	}
	public String[] getFilename_ext() {
		return filename_ext;
	}
	public void setFilename_ext(String[] filename_ext) {
		this.filename_ext = filename_ext;
	}
	public String[] getFilename_400() {
		return filename_400;
	}
	public void setFilename_400(String[] filename_400) {
		this.filename_400 = filename_400;
	}
	public String[] getFilename_100() {
		return filename_100;
	}
	public void setFilename_100(String[] filename_100) {
		this.filename_100 = filename_100;
	}
	public String[] getFilename_original() {
		return filename_original;
	}
	public void setFilename_original(String[] filename_original) {
		this.filename_original = filename_original;
	}
	
	@Override
	public String toString() {
		return "SampleForm [boardId=" + Arrays.toString(boardId)
				+ ", filename=" + Arrays.toString(filename) + ", filename_ext="
				+ Arrays.toString(filename_ext) + ", filename_400="
				+ Arrays.toString(filename_400) + ", filename_100="
				+ Arrays.toString(filename_100) + ", filename_original="
				+ Arrays.toString(filename_original) + "]";
	}
}
