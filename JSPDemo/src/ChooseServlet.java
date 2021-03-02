

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChooseServlet
 */
@WebServlet("/ChooseServlet")
public class ChooseServlet extends HttpServlet
{

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
	 RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
	 dispatch.forward(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 {
	 String choice = request.getParameter("radioJSPCool");
	 HttpSession session = request.getSession();
	 if(choice.equalsIgnoreCase("1")) {
		 session.setAttribute("radioJSPCoolYes", "checked");
		 session.setAttribute("radioJSPCoolNo", "unchecked");
	 }
	 if(choice.equalsIgnoreCase("0")) {
		 session.setAttribute("radioJSPCoolNo", "checked");
		 session.setAttribute("radioJSPCoolYes", "unchecked");
	 }
	 
	 RadioState JSFwayCool = new RadioState();
	 choice = request.getParameter("JSFwayCool");
	 if (choice != null) {
		 JSFwayCool.setYesCheck(choice.equalsIgnoreCase("1")?"checked":"unchecked");
		 JSFwayCool.setNoCheck(choice.equalsIgnoreCase("0")?"checked":"unchecked");
	 }
	 session.setAttribute("JSFwayCool", JSFwayCool);
	 
	 RadioState moonCheese = new RadioState();
	 choice = request.getParameter("moonCheese");
	 if (choice != null) {
		 moonCheese.setYesCheck(choice.equalsIgnoreCase("1")?"checked":"unchecked");
		 moonCheese.setNoCheck(choice.equalsIgnoreCase("0")?"checked":"unchecked");
	 }
	 session.setAttribute("moonCheese", moonCheese);
	 
	 if (choice != null)
		 System.out.println ("choice= "+ choice);
	 else
		 System.out.println("No choice made");
	 RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
	 dispatch.forward(request, response);
 }
}