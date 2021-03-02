

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Quiz
 */
@WebServlet("/Quiz")
public class NumberQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberQuiz() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
   		 throws ServletException, IOException {
		 Quiz q = new Quiz();
		 q.setQuestion(q.firstQuestion());
		 HttpSession session = request.getSession();
		 session.setAttribute("Quiz", q);
		 session.removeAttribute("Age");
		 session.removeAttribute("AgeError");
		 session.removeAttribute("TryAgain");
		 RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
		 dispatch.forward(request, response);
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 Quiz q = (Quiz)session.getAttribute("Quiz");
		 String answer = request.getParameter("answer");
		 String ageStr = request.getParameter("age");
		 session.removeAttribute("Age");
		 int age;
		 try {
			 age = Integer.parseInt(ageStr);
			 if(age < 4 || age > 100) {
				 session.setAttribute("AgeError", "Age invalid. Age must be between 4 and 100.");
				 RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
				 dispatch.forward(request, response);
				 return;
			 }
			 session.removeAttribute("AgeError");
			 q.setAge(age);
			 session.setAttribute("Age", age);
		 }catch(Exception ex) {
			 session.setAttribute("AgeError", "Age is required.");
			 RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
			 dispatch.forward(request, response);
			 return;
		 }
		 session.removeAttribute("TryAgain");
		 boolean result = q.checkAnswer(answer);
		 if((!result && q.getTimeOfTry() > 3) || result)
			 q.setQuestion(q.nextQuestion());
		 else
			 session.setAttribute("TryAgain", String.format("Attempt %d/%d",q.getTimeOfTry(),3));	 
		 session.setAttribute("Quiz", q);
		
		 if(!q.finished()) {
			 RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
			 dispatch.forward(request, response);
		 } else {
			 RequestDispatcher dispatch = request.getRequestDispatcher("Complete.jsp");
			 dispatch.forward(request, response);
		 }
	 }

}
