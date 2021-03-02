
public class Quiz {
	 int curQuestion;
	 int score;
	 String question;
	 public Quiz() {
		 score = 0;
		 curQuestion = 0;
	 }
	 
	 
	 public int getCurQuestion() {
		return curQuestion;
	}


	public void setCurQuestion(int curQuestion) {
		this.curQuestion = curQuestion;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public void checkAnswer(String answer) {
		 int correctAnswer = Database.getAnswer(curQuestion);
		 int userAnswer = Integer.parseInt(answer);
		 if(userAnswer == correctAnswer)
			 score++;
	 }
	 
	 public String firstQuestion() {
		 return Database.getQuestion(0);
	 }
	 public String nextQuestion() {
		 curQuestion++;
		 return Database.getQuestion(curQuestion);
	 }
	 
	 public boolean finished() {
		 return curQuestion == Database.length() - 1;
	 }
	 public int getNumofQuestions() {
		 return Database.length();
	 }
}
