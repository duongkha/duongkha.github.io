

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 request.getSession().setAttribute("Quiz", q);
		 RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
		 dispatch.forward(request, response);
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		 Quiz q = (Quiz)request.getSession().getAttribute("Quiz");
		 String answer = request.getParameter("answer");
		 q.checkAnswer(answer);
		 q.setQuestion(q.nextQuestion());
		 request.getSession().setAttribute("Quiz", q);
		
		 if(!q.finished()) {
			 RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
			 dispatch.forward(request, response);
		 } else {
			 RequestDispatcher dispatch = request.getRequestDispatcher("Complete.jsp");
			 dispatch.forward(request, response);
		 }
	 }

}
