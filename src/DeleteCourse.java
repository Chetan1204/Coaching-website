
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCourse
 */
@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String cname = request.getParameter("cname");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");
			String qr = "delete from course where cname=?";
			PreparedStatement ps = con.prepareStatement(qr);
			ps.setString(1, cname);
			int i = ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("Show");
			if (i > 0) {
				rd.include(request, response);
				out.println("deleted");
			} 
			else 
			{
				rd.include(request, response);
				out.println("not delete");
			}
			con.close();
		} catch (Exception e) {
			out.println(e);
		}
	}

}
