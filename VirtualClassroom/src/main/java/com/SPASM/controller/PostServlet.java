package com.SPASM.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.SPASM.DAO.DatabaseDAO;
import com.SPASM.model.PostMsg;

@MultipartConfig(
		fileSizeThreshold = 1024*1024*10,//10MB
		maxFileSize = 1024*1024*50,//50MB
		maxRequestSize = 1024*1024*100//100MB
		)
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String author;
    public PostServlet() {
        super();
        
    }

    InputStream inputStream = null;
   DatabaseDAO dao=new DatabaseDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		 response.setContentType("text/html;charset=UTF-8");
		
		String st=request.getParameter("msg");
		System.out.println(request.getParameter("authorName"));
		String author=request.getParameter("authorName");
		Part filePart = request.getPart("file_uploaded");
		 
		 //String filename = request.getParameter("file_uploaded");           
		 //String r=  request.getRealPath(filename); 
		 
		 //System.out.println(filename+":"+r);
		 
        
         if (filePart != null) 
         {
             System.out.println(filePart.getSubmittedFileName());
             System.out.println(filePart.getSize());
             System.out.println(filePart.getContentType());
             inputStream = filePart.getInputStream();
         }
		
		HttpSession session=request.getSession();
		String classcode=(String) session.getAttribute("classcode");
		String classname=(String) session.getAttribute("classname");
		System.out.println("post to:"+classcode);
		
	PostMsg m=new PostMsg();
	m.setMsg(st);
	m.setCode(classcode);
	m.setFilename(filePart.getSubmittedFileName());
	m.setFile(filePart);
	m.setAuthorName(author);
    
	try {
		dao.msgInsert(m,inputStream);
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}

	response.sendRedirect("CreateTeacher.jsp?code="+classcode+"&classname="+classname+"&author="+author);//URL re-writing
	}
	

}
