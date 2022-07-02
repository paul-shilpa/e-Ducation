<%@page import="com.SPASM.DAO.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.sql.*"%>
<%
int i=0;
Db_Connection  dbconn=new Db_Connection () ;
System.out.println("msg call");
System.out.println(request.getParameter("mail"));



String mail=request.getParameter("mail");

String quary = "select * from registration where mailid=?";
	
	try {



Connection con= dbconn.Connection();

System.out.println("connected check mail..");//connection

PreparedStatement st = con.prepareStatement(quary);
st.setString(1, mail);
ResultSet rs = st.executeQuery();

if(rs.next()){
i++;
}
System.out.println(i);
if(i==1)
{
	
	out.println("mail not available");
	
	

}
	}catch(Exception e)
	{
		e.printStackTrace();
	}





%>
