<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connnections.DBConnection"%>
    
<%
int id = Integer.parseInt(request.getParameter("id"));

%>
<!DOCTYPE html>
<html>
<body>

<%
try{
	Connection con=DBConnection.connect();
	String sql ="delete from spot where BSid=?";
	PreparedStatement pstmt;

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,id);
		int i = pstmt.executeUpdate();
	if(i>0)
	{ 
		response.sendRedirect("ViewBSpotAll.jsp");
	}
}
catch(Exception e)
{
	e.printStackTrace();
}
%>



</body>
</html>