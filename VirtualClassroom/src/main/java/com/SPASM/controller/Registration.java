package com.SPASM.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SPASM.DAO.DatabaseDAO;
import com.SPASM.model.RegistrationModel;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Registration() {
        super();
       
    }
    RegistrationModel rm=new RegistrationModel();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("welcome..registration");
		String name=request.getParameter("user");
		String mail=request.getParameter("mail");
	  	String pass=request.getParameter("pass");
	  	
	  	rm.setMailId(mail);
	  	rm.setUser(name);
	  	rm.setPassword(pass);
	  	
	  	
	  	DatabaseDAO dao=new DatabaseDAO();
	  	try {
			dao.registrationInsert(rm);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	  
	  	
	  	HttpSession session=request.getSession();
    	session.setAttribute("mailid", mail);
	  	response.sendRedirect("StartingPage.jsp?mail="+mail);
	  		//response.sendRedirect("ClassLogin.jsp");
	  	

	}

}
