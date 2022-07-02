package com.SPASM.model;

public class StudentAssignmentReplyModel {
	private String assign_comment;
	private String id;
	private String author;
	private String comment_title;
	private String comment_classcode;
	public String getAssign_comment() {
		return assign_comment;
	}
	public void setAssign_comment(String assign_comment) {
		this.assign_comment = assign_comment;
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
