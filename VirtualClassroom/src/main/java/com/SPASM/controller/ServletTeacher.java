package com.SPASM.controller;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SPASM.DAO.DatabaseDAO;
import com.SPASM.model.Teacher;
import com.SPASM.required.RandomAlphanumeric;


public class ServletTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletTeacher() {
        super();
       
    }
    RandomAlphanumeric r=new RandomAlphanumeric();
    DatabaseDAO dao=new DatabaseDAO();  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classname=request.getParameter("classname");
		//String classdescription=request.getParameter("classdescription");
		String section=request.getParameter("section");
		String name=request.getParameter("teacher_name");
		
		String subject=request.getParameter("subject");
		//String teachername=request.getParameter("teachername");
					String mailid=request.getParameter("mailid");
		//String password=request.getParameter("password");
				
		Teacher t=new Teacher();
		t.setClassname(classname);
		//t.setClassdescription(classdescription);
		t.setSection(section);
		t.setName(name);
		
		t.setSubject(subject);
		//t.setTeachername(teachername);
		t.setMailid(mailid);
		///t.setPassword(password);
		t.setClasscode(r.generateAlphaNumeric(6));
		
		System.out.println("randomly generated alphanumeric classcode:"+t.getClasscode());
		
		
		try {
			dao.insert(t);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		//PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
//		session.setAttribute("classname",classname);
//		session.setAttribute("section", section);
		session.setAttribute("classcode", t.getClasscode());
		session.setAttribute("mail", mailid);
//		session.setAttribute("subject",subject);
//		session.setAttribute("room",room);
		
		response.sendRedirect("StartingPage.jsp?mail="+mailid);
		
		
	}
}