<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.connnections.DBConnection"%>



<%
 
ResultSet resultSet = null;
%>    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title></title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  
  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="index.html" class="logo"><b>black<span> spot</span></b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">
        <!--  notification start -->
        <ul class="nav top-menu">
          <!-- settings start -->
          <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
              <i class="fa fa-tasks"></i>
              
              </a>
            
          </li>
          <!-- settings end -->
          
      </div>
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li>
            <a class="logout" href="index.html">Logout</a>
          </li>
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered">
            
          </p>
          
          <li class="mt">
            <a href="#">
              <i class=""></i>
              <span>Dashboard</span>
              </a>
          </li>
		  <li class="mt">
           <a href="CreateBSpot.html">
              <i class="fa fa-dashboard"></i>
              <span>Add Black Spots</span>
              </a>
          </li>
		  <li class="mt">
            <a href="ViewBSpot.jsp">
              <i class="fa fa-dashboard"></i>
              <span>View Black Spots</span>
              </a>
          </li>
		  <li class="mt">
            <a href="ViewZone.jsp">
              <i class="fa fa-dashboard"></i>
              <span>Zonewise Black Spots</span>
              </a>
          </li>
		  <li class="mt">
            <a href="ViewReason.jsp">
              <i class="fa fa-dashboard"></i>
              <span>Reasonwise Black Spots</span>
              </a>
          </li>
          <li class="mt">
            <a href="ViewCity.jsp">
              <i class="fa fa-dashboard"></i>
              <span>Citywise Black Spots</span>
              </a>
          </li>
      </div>
    </aside>
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <h3><i class="fa fa-angle-right"></i> Black Spots</h3>
        <div class="row">
          <div class="col-md-12">
            <div class="content-panel">
              <h4><i class="fa fa-angle-right">Yellow Zone</i></h4>
              <hr>
              <table class="table">
                <thead>
                  <tr>
                   
                    <th>Location Name</th>
					<th>ReasonType</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
					<th>Level</th>
					<th>City</th>
					
                  </tr>
                </thead>
                <tbody>
                  <%
try{
	Connection con=DBConnection.connect();
	String sql ="select * from spot where level='0'";
	
	PreparedStatement pstmt;
	pstmt = con.prepareStatement(sql);
	

	resultSet = pstmt.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString(3) %></td>
<td><%=resultSet.getString(5) %></td>
<td><%=resultSet.getString(7) %></td>
<td><%=resultSet.getString(8) %></td>
<td><%=resultSet.getString(9) %></td>
<td><%=resultSet.getString(10) %></td>

</tr>
<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
                </tbody>
              </table>
            </div>
            
            
            <div class="content-panel">
              <h4><i class="fa fa-angle-right">Orange Zone</i></h4>
              <hr>
              <table class="table">
                <thead>
                  <tr>
                   
                    <th>Location Name</th>
					<th>ReasonType</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
					<th>Level</th>
					<th>City</th>
					
                  </tr>
                </thead>
                <tbody>
                  <%
try{
	Connection con=DBConnection.connect();
	String sql ="select * from spot where level='1'";
	
	PreparedStatement pstmt;
	pstmt = con.prepareStatement(sql);
	

	resultSet = pstmt.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString(3) %></td>
<td><%=resultSet.getString(5) %></td>
<td><%=resultSet.getString(7) %></td>
<td><%=resultSet.getString(8) %></td>
<td><%=resultSet.getString(9) %></td>
<td><%=resultSet.getString(10) %></td>

</tr>
<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
                </tbody>
              </table>
            </div>
            
            
            
            <div class="content-panel">
              <h4><i class="fa fa-angle-right">Red Zone</i></h4>
              <hr>
              <table class="table">
                <thead>
                  <tr>
                   
                    <th>Location Name</th>
					<th>ReasonType</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
					<th>Level</th>
					<th>City</th>
					
                  </tr>
                </thead>
                <tbody>
                  <%
try{
	Connection con=DBConnection.connect();
	String sql ="select * from spot where level='2'";
	
	PreparedStatement pstmt;
	pstmt = con.prepareStatement(sql);
	

	resultSet = pstmt.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString(3) %></td>
<td><%=resultSet.getString(5) %></td>
<td><%=resultSet.getString(7) %></td>
<td><%=resultSet.getString(8) %></td>
<td><%=resultSet.getString(9) %></td>
<td><%=resultSet.getString(10) %></td>

</tr>
<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
                </tbody>
              </table>
            </div>
            
            
            
          </div>
          <!-- /col-md-12 -->
         
          <!-- /col-md-12 -->
        </div>
        <!-- row -->
        
        
        <!-- /row -->
      </section>
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    <!--footer start-->
    
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <!--script for this page-->
  
</body>

</html>