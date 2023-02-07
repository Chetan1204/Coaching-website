

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updcr
 */
@WebServlet("/Updcr")
public class Updcr extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String cname=request.getParameter("cname");
		String f=request.getParameter("fees");
		int fees=Integer.parseInt(f);
		String duration=request.getParameter("duration");
		String trainer=request.getParameter("trainer");
		out.println("<form action='UpdateCourse'>");
		out.println(cname);
		out.println("<input type='hidden' name='cname' value="+cname+" /><br>");
		out.println("FEE : <input type='number' name='fees' value="+fees+" /><br>");
		out.println("DURATION : <input type='text' name='duration' value="+duration+" /><br>");
		out.println("TRAINER : <input type='text' name='trainer' value="+trainer+" /><br>");
		out.println("<input type='submit' value='Update' />");
		out.println("</form>");
	}

}
