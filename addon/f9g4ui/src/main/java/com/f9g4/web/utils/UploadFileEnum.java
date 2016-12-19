package com.f9g4.web.utils;

public enum UploadFileEnum {

	JPG("JPG","upload.jpg.title","upload.jpg.contnet","upload.jpg.types","upload.jpg.success","upload.jpg.fail"),
	AI("AI","upload.ai.title","upload.ai.content","upload.ai.types","upload.ai.success","upload.ai.fail"),
	FILES("FILES","upload.files.title","upload.files.content","upload.files.types","upload.files.success","upload.files.fail"),
	;

	private final String filetype;
	private final String titleMessageCode;
	private final String contentMessageCode;
	private final String typesMessageCode;
	private final String successMessageCode;
	private final String failMessageCode;

	UploadFileEnum(String filetype, String titleMessageCode, String contentMessageCode, String typesMessageCode, String successMessageCode, String failMessageCode){
		this.filetype = filetype;
		this.titleMessageCode = titleMessageCode;
		this.contentMessageCode = contentMessageCode;
		this.typesMessageCode = typesMessageCode;
		this.successMessageCode = successMessageCode;
		this.failMessageCode = failMessageCode;
	}

	public String getFiletype() {
		return filetype;
	}

	public String getTitleMessageCode() {
		return titleMessageCode;
	}

	public String getContentMessageCode() {
		return contentMessageCode;
	}

	public String getSuccessMessageCode() {
		return successMessageCode;
	}

	public String getFailMessageCode() {
		return failMessageCode;
	}

	public String getTypesMessageCode() {
		return typesMessageCode;
	}

}
