import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/JSPIntroServlet")
public class JSPIntroServlet extends HttpServlet
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
 {
	 RequestDispatcher dispatcher = request.getRequestDispatcher("Hello.jsp");
	 dispatcher.forward(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
	 RequestDispatcher dispatcher =
	request.getRequestDispatcher("PostMessages.jsp");
	 dispatcher.forward(request, response);
 }
}
