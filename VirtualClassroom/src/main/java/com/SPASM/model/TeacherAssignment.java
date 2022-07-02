package com.SPASM.model;

import java.sql.Date;
import java.sql.Time;


import javax.servlet.http.Part;

public class TeacherAssignment {
	private String title;
	private String instruction;
	private String points;
	private String due;
	private String dueTime;
	
	private String topic;
	private String classname;
	private String classcode;
	private String assign_file_name;
	private Part assignFile;
	private String  authorName;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getDue() {
		return due;
	}
	public void setDue(String due) {
		this.due = due;
	}
	public String getDueTime() {
		return dueTime;
	}
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public String getAssign_file_name() {
		return assign_file_name;
	}
	public void setAssign_file_name(String assign_file_name) {
		this.assign_file_name = assign_file_name;
	}
	public Part getAssignFile() {
		return assignFile;
	}
	public void setAssignFile(Part assignFile) {
		this.assignFile = assignFile;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	
	
	
	
}
