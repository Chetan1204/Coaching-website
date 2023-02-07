<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<%
String cname=request.getParameter("cname");
String email=(String) session.getAttribute("id");
	String qr="insert into register values(?,?)";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1, cname);
	ps.setString(2, email);
	int i=ps.executeUpdate();
	RequestDispatcher rd=request.getRequestDispatcher("Uhome.jsp");
	rd.include(request, response);
	if(i>0)
	{
		out.println("<script>window.alert('registerd sucessfully our team will contact you soon');</script>");
	}
	else
	{
		out.println("<script>window.alert('registration failed');</script>");
	}
	con.close();
%>