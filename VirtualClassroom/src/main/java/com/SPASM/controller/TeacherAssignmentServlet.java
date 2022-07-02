package com.SPASM.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.SPASM.DAO.DatabaseDAO;
import com.SPASM.model.TeacherAssignment;

@MultipartConfig(maxFileSize = 60177215)
public class TeacherAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TeacherAssignmentServlet() {
        super();
       
    }

    InputStream inputStream = null;
    DatabaseDAO dao=new DatabaseDAO();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("welcome to create assignment..");
		
		
		//Date due = null;
		//Date time=null;
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("instruction"));
		System.out.println(request.getParameter("points"));
		System.out.println(request.getParameter("due"));
		System.out.println(request.getParameter("time"));
		System.out.println(request.getParameter("topic"));
		
		String title=request.getParameter("title");
		String instruction=request.getParameter("instruction");
		
		String points=request.getParameter("points");
		

		String getDue=request.getParameter("due");
		String getTime=request.getParameter("time");
//		try {
//			due = (Date) new SimpleDateFormat("dd-MMM-yyyy").parse(getDue);
//		} catch (ParseException e1) {

//
//			e1.printStackTrace();
//		}
//		
		
//		
//		try {
//		time = (Date) new SimpleDateFormat("HH:mm p").parse(getTime);
//		} catch (ParseException e1) {
//
//
//			e1.printStackTrace();
//		} 
		
		String topic=request.getParameter("topic");
		
		
		
		
		 
		Part filePart = request.getPart("file_assign");
        
        if (filePart != null) 
        {
            System.out.println(filePart.getSubmittedFileName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            inputStream = filePart.getInputStream();
        }
		
        /*getting author name from hidden input for URl re-Writing*/
        System.out.println(request.getParameter("authorName"));
		String author=request.getParameter("authorName");
        /*end*/
		
       /*create session*/
		HttpSession session=request.getSession();
		String classcode=(String) session.getAttribute("classcode");
		String classname=(String) session.getAttribute("classname");
		System.out.println("assign to:"+classcode);
		/*end*/
		
		TeacherAssignment ta=new TeacherAssignment();
		ta.setClasscode(classcode);
		ta.setClassname(classname);
		ta.setTitle(title);
		ta.setInstruction(instruction);
		ta.setPoints(points);
		ta.setDueTime(getTime);
		ta.setDue(getDue);
		ta.setTopic(topic);
		ta.setAssign_file_name(filePart.getSubmittedFileName());
		ta.setAssignFile(filePart);
		ta.setAuthorName(author);
		
		try {
			dao.assignmentTeacherInsert(ta,inputStream  );
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		response.sendRedirect("TeacherCreate.jsp?code="+classcode+"&classname="+classname+"&author="+author);//URL re-writing
	}

}
