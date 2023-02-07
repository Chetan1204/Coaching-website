

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advance","root","root");
			 String qr="select * from course";
			 Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery(qr);
			 if(rs.next())
			 {
				 out.println("<table align='center' border='1px' >");
				 do
				 {
					 String cname=rs.getString("cname");
					 String duration=rs.getString("duration");
					 String trainer=rs.getString("trainer");
					 int fees=rs.getInt("fees");
					 out.println("<tr>");
					 out.println("<td>");
					 out.println(cname);
					 out.println("</td>");
					 out.println("<td>");
					 out.println(duration);
					 out.println("</td>");
					 out.println("<td>");
					 out.println(fees);
					 out.println("</td>");
					 out.println("<td>");
					 out.println(trainer);
					 out.println("</td>");
					 out.println("<td>");
					 out.println("<a href=DeleteCourse?cname="+cname+">Delete</a>");
					 out.println("</td>");
					 out.println("<td>");
					 out.println("<a href=Updcr?cname="+cname+"&duration="+duration+"&fees="+fees+"&trainer="+trainer+">Update</a>");
					 out.println("</td>");
					 out.println("</tr>");
				 }while(rs.next());
				 out.println("</table>");
			 }
			 else
			 {
				 out.println("no data found");
			 }
			 con.close();
		 }catch (Exception e){
			 out.println(e);
		 }
	}

}
