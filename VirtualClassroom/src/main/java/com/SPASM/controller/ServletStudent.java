
package com.SPASM.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SPASM.DAO.DatabaseDAO;
import com.SPASM.model.Student;



public class ServletStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletStudent() {
        super();
      
    }

    DatabaseDAO dao=new DatabaseDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String smailid=request.getParameter("mailid");
		
		String scontactno=request.getParameter("contactno");
		String sname=request.getParameter("sname");
		String classcode=request.getParameter("classcode");
		Student s=new Student();
		
		
		s.setMailid(smailid);
		s.setContactno(scontactno);
		
		s.setStudentCode(classcode);
		s.setSname(sname)	;
		
		
		try {
			if(dao.search(classcode))
			{
				dao.studentInsert(s);
				System.out.println("true");
				HttpSession session=request.getSession();
				session.setAttribute("classcode",classcode);
				response.sendRedirect("StartingPage.jsp?mail="+smailid);
				
			}
			else
			{
				System.out.println("false");
				response.sendRedirect("JoinClass.jsp");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
