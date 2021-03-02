

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		 request.getSession().setAttribute("quiz", q);
		 PrintWriter out = response.getWriter();
		 out.print("<html><head><title>The Number Quiz</title></head><body>");
		 out.print("<form method='post'>");
		 out.print("<p>Your score is: 0</p>");
		 out.print("<p>Guess the next number in the sequence</p>");
		 out.print(String.format("<p>%s</p>", q.firstQuestion()));
		 out.print("<span>Your Answer:</span><input name='answer'/>");
		 out.print("<input type='submit' value='Submit'/>");
		 out.print("</form>");
		 out.print("</body></html>");
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		 Quiz q = (Quiz)request.getSession().getAttribute("quiz");
		 String answer = request.getParameter("answer");
		 q.checkAnswer(answer);
		 PrintWriter out = response.getWriter();
		 if(!q.finished()) {
			 out.print("<html><head><title>The Number Quiz</title></head><body>");
			 out.print("<form method='post'>");
			 out.print(String.format("<p>Your score is: %d</p>", q.getScore()));
			 out.print("<p>Guess the next number in the sequence</p>");
			 out.print(String.format("<p>%s</p>", q.nextQuestion()));
			 out.print("<span>Your Answer:</span><input name='answer'/>");
			 out.print("<input type='submit' value='Submit'/>");
			 out.print("</form>");
			 out.print("</body></html>");
		 } else {
			 out.print("<html><head><title>The Number Quiz</title></head><body>");
			 out.print("<form method='post'>");
			 out.print(String.format("<p>Your score is: %d</p>", q.getScore()));
			 out.print(String.format("<span>You have completed the Number Quiz, with a score of %d out of %d.</span>", q.getScore(), q.getNumofQuestions()));
			 out.print("</form>");
			 out.print("</body></html>");
		 }
	 }

}
