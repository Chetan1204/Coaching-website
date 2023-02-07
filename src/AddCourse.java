

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;


@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	
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
			String qr="insert into course values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, cname);
			ps.setInt(2, fees);
			ps.setString(3, duration);
			ps.setString(4, trainer);
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("added");
			}
			else
			{
				out.println("not added");
			}
			con.close();
		}catch(Exception e){
			out.println(e);
		}
	}

}
