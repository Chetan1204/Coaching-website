

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Uhome
 */
@WebServlet("/Uhome")
public class Uhome extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Welcome to user home</h1>");
		out.println("<a href='Logout'>Logout</a>");
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("id");
		out.println(email);
	}

}
