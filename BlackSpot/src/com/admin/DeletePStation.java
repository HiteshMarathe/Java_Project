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
 * Servlet implementation class DeletePStation
 */
public class DeletePStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePStation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int PSid=Integer.parseInt(request.getParameter("PSid"));
		try
		{
			
			String s="delete from policestation where PSid=?";	
			Connection con=DBConnection.connect();
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, PSid);
			
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("ViewPStation.jsp");
			}
			else
			{
				response.sendRedirect("fail.html");
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
