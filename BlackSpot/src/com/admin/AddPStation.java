package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connnections.*;

/**
 * Servlet implementation class AddPStation
 */
public class AddPStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPStation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=0;
		String name=request.getParameter("name");
		String email=request.getParameter("Email");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		String pass=request.getParameter("pass");
		String city=request.getParameter("city");
		try
		{
			
			String s="insert into policestation values(?,?,?,?,?,?,?)";	
			Connection con=DBConnection.connect();
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3,email);
			pstmt.setString(4, address);
			pstmt.setString(5, contact);
			pstmt.setString(6, pass);
			pstmt.setString(7, city);
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("ViewPStation.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
