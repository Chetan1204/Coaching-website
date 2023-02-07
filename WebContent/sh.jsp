<%@page errorPage="error.jsp" %>
<%@include file="db.jsp" %>
<% String iname=request.getParameter("iname"); %>
<%

String cname=(String)session.getAttribute("cname"); 
String qr="update course set img=? where cname=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1, iname);
ps.setString(2, cname);
int i=ps.executeUpdate();
out.println(i+"record added");
%>
