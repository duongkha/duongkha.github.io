

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleCalculator
 */
@WebServlet("/SimpleCalculator")
public class SimpleCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String HTML = "<html>" +
									"<head><title>SIMPLE CALCULATOR</title></head>" +
									"<body>" +
										"<h1 align=\"center\">SIMPLE CALCULATOR</h1>" +
										"<form method = \"get\" action = \"SimpleCalculator\">" +
											"<input type = \"text\" name=\"number1\" value=\"%s\"> + <input type = \"text\" name=\"number2\" value=\"%s\"> = <input type = \"text\" name=\"result1\" value=\"%s\"><br><br>" +
											"<input type = \"text\" name=\"number3\" value=\"%s\"> * <input type = \"text\" name=\"number4\" value = \"%s\"> = <input type = \"text\" name=\"result2\" value=\"%s\"><br><br>" +
											"<input type = \"submit\" name = \"result\" value = \"submit\"><br><br>" +
										"</form>" +
									"</body>" +
								"</html>";
    /**
     * Default constructor. 
     */
    public SimpleCalculator() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		try {
			response.setContentType("text/html");
			String number1 = request.getParameter("number1");
			String number2 = request.getParameter("number2");
			String number3 = request.getParameter("number3");
			String number4 = request.getParameter("number4");
			String result1 = "";
			String result2 = "";
			if(!number1.isEmpty() && !number2.isEmpty()) {
				int num1 = Integer.parseInt(number1);
				int num2 = Integer.parseInt(number2);
				result1 = String.valueOf(num1 + num2);
			}
			if(!number3.isEmpty() && !number4.isEmpty()) {
				int num3 = Integer.parseInt(number3);
				int num4 = Integer.parseInt(number4);
				result2 = String.valueOf(num3 * num4);
			}
			
			response.setContentType("text/html");
			
			msg = String.format(HTML, number1, number2,result1,number3, number4,result2);
			PrintWriter p = response.getWriter();
			p.println(msg);
		}
		catch(Exception e) {}
		}
}
