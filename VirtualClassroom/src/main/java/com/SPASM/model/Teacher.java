package com.SPASM.model;

public class Teacher {
	private String classname;
	//private String classdescription;
	private String section;
	private String name;
	private String subject;
	private String mailid;
	//private String teachername;
	//public String getTeachername() {
		//return teachername;
	//}//
	//public void setTeachername(String teachername) {
		//this.teachername = teachername;
	//}
	//private String password;
	private String classcode;
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	//public String getClassdescription() {
		//return classdescription;
	//}
	//public void setClassdescription(String classdescription) {
		//this.classdescription = classdescription;
	//}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	@Override
	public String toString() {
		return "Teacher [classcode=" + classcode + "]";
	}

	
	

}