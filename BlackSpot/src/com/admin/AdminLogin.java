package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connnections.DBConnection;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String role=request.getParameter("role");
		System.out.println(role);
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		Connection con=DBConnection.connect();
		PreparedStatement pstmt;
		
		
				switch(role)
				{
				case "admin":
					try {
						
						pstmt = con.prepareStatement("select * from admin where Email=? and Pass=?");
						pstmt.setString(1,email);
						pstmt.setString(2, pass);
						ResultSet rs=pstmt.executeQuery();
						if(rs.next())
						{
							int id=rs.getInt(1);
							String uemail=rs.getString("Email");
							properties.setEmail(uemail);
							properties.setId(id);
							response.sendRedirect("CreatePStation.html");
						}
						else{
							response.sendRedirect("error.html");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				break;
				case"police station":
					try {
						
						pstmt = con.prepareStatement("select * from policestation where Email=? and Pass=?");
						pstmt.setString(1,email);
						pstmt.setString(2, pass);
						ResultSet rs=pstmt.executeQuery();
						if(rs.next())
						{
							int id=rs.getInt(1);
							String uemail=rs.getString("Email");
							properties.setEmail(uemail);
							properties.setId(id);
							response.sendRedirect("CreateBSpot.html");
						}
						else{
							response.sendRedirect("error.html");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				break;
				case"user":
					try {
						
						pstmt = con.prepareStatement("select * from user where Email=? and Pass=?");
						pstmt.setString(1,email);
						pstmt.setString(2, pass);
						ResultSet rs=pstmt.executeQuery();
						if(rs.next())
						{
							int id=rs.getInt(1);
							String uemail=rs.getString("Email");
							properties.setEmail(uemail);
							properties.setId(id);
							response.sendRedirect("UserViewCity.jsp");
						}
						else{
							response.sendRedirect("error.html");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				break;
				}
				
					
}
				
			
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
