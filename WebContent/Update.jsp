<%@include file="db.jsp" %>
<%
String cname=request.getParameter("cname");
String f=request.getParameter("fees");
int fees=Integer.parseInt(f);
String duration=request.getParameter("duration");
String trainer=request.getParameter("trainer");
	String qr="update course set fees=?,duration=?,trainer=? where cname=?";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(4, cname);
	ps.setInt(1, fees);
	ps.setString(2, duration);
	ps.setString(3, trainer);
	int i=ps.executeUpdate();
	RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
	rd.include(request, response);
	if(i>0)
	{
		out.println("updated");
	}
	else
	{
		out.println("not update");
	}
	con.close();
%>