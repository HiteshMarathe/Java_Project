

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.properties;
import com.connnections.DBConnection;

/**
 * Servlet implementation class AddBSpot
 */
public class AddBSpot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBSpot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int BSid=0;
		String location=request.getParameter("location");
		String address=request.getParameter("address");
		String reasontype=request.getParameter("reasontype");
		String reason=request.getParameter("reason");
		String latitude=request.getParameter("latitude");
		String longitude=request.getParameter("longitude");
		String level=request.getParameter("level");
		String city=request.getParameter("city");
		try
		{
			
			String s="insert into spot values(?,?,?,?,?,?,?,?,?,?)";	
			Connection con=DBConnection.connect();
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, BSid);
			pstmt.setInt(2, properties.getId());
			pstmt.setString(3,location);
			pstmt.setString(4, address);
			pstmt.setString(5, reasontype);
			pstmt.setString(6, reason);
			pstmt.setString(7, latitude);
			pstmt.setString(8, longitude);
			pstmt.setString(9, level);
			pstmt.setString(10, city);
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("ViewBSpot.jsp");
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
