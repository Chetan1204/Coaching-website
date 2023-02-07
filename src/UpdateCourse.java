

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

/**
 * Servlet implementation class UpdateCourse
 */
@WebServlet("/UpdateCourse")
public class UpdateCourse extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	String cname=request.getParameter("cname");
	String f=request.getParameter("fees");
	int fees=Integer.parseInt(f);
	String duration=request.getParameter("duration");
	String trainer=request.getParameter("trainer");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance","root","root");
		String qr="update course set fees=?,duration=?,trainer=? where cname=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(4, cname);
		ps.setInt(1, fees);
		ps.setString(2, duration);
		ps.setString(3, trainer);
		int i=ps.executeUpdate();
		RequestDispatcher rd=request.getRequestDispatcher("Show");
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
	}catch(Exception e){
		out.println(e);
	}
	}

}
