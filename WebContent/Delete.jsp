<%@include file="db.jsp" %>
<%
String cname=request.getParameter("cname");
	String qr="delete from course where cname=?";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1, cname);
	int i=ps.executeUpdate();
	RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
	if(i>0)
	{
		rd.include(request, response);
		out.println("deleted");
	}
	else
	{
		rd.include(request, response);
		out.println("not delete");
	}
	con.close();
%>