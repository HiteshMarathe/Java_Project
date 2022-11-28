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
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int Uid=0;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String mobile=request.getParameter("mobile");
		String city=request.getParameter("city");
		try
		{
			
			String s="insert into user values(?,?,?,?,?,?)";	
			Connection con=DBConnection.connect();
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(s);
//			System.out.println("Enter Account Number: ");
//			AccNo=sc.nextInt();
			pstmt.setInt(1, Uid);
			pstmt.setString(2, name);
			pstmt.setString(3,email);
			pstmt.setString(4, pass);
			pstmt.setString(5, mobile);
			pstmt.setString(6, city);
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("index.html");
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
