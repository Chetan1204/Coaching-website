<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<%
String cname=request.getParameter("cname");
session.setAttribute("cname", cname);
String f=request.getParameter("fees");
int fees=Integer.parseInt(f);
String duration=request.getParameter("duration");
String trainer=request.getParameter("trainer");

	String qr="insert into course (cname,fees,duration,trainer) values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1, cname);
	ps.setInt(2, fees);
	ps.setString(3, duration);
	ps.setString(4, trainer);
	int i=ps.executeUpdate();
%>
      Select a file to upload: <br />
      <form action = "UploadServlet.jsp" method = "post"
         enctype = "multipart/form-data">
         <input type = "file" name = "file" size = "50" />
         <br />
         <input type = "submit" value = "Upload File" />
      </form>