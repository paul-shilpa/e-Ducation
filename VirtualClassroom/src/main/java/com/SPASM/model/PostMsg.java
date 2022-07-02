package com.SPASM.model;

import javax.servlet.http.Part;

public class PostMsg {
//	private List<String> msg=new ArrayList<String>();
//
//	public List<String> getMsg() {
//		return msg;
//	}
//
//	public void setMsg(List<String> msg) {
//		this.msg = msg;
//	}
private String msg;
private String code;
private Part file;
private String filename;
private String authorName;


public String getAuthorName() {
	return authorName;
}

public void setAuthorName(String authorName) {
	this.authorName = authorName;
}

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public Part getFile() {
	return file;
}

public void setFile(Part file) {
	this.file = file;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

	

	

}
