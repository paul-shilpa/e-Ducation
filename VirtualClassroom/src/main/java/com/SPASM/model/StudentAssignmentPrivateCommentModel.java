package com.SPASM.model;

public class StudentAssignmentPrivateCommentModel {
	private String id;
	private String author;
	private String comment_title;
	private String comment_classcode;
	private String private_comment;
	
	public String getPrivate_comment() {
		return private_comment;
	}
	public void setPrivate_comment(String private_comment) {
		this.private_comment = private_comment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getComment_title() {
		return comment_title;
	}
	public void setComment_title(String comment_title) {
		this.comment_title = comment_title;
	}
	public String getComment_classcode() {
		return comment_classcode;
	}
	public void setComment_classcode(String comment_classcode) {
		this.comment_classcode = comment_classcode;
	}
	
}
