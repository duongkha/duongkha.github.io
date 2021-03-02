
public class Quiz {
	 int curQuestion;
	 int score;
	 String question;
	 int age;
	 int timeOfTry;
	 String grade;
	 public Quiz() {
		 score = 0;
		 curQuestion = 0;
		 timeOfTry = 1;
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


	public int getAge() {
		return age;
	}
	

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAgeDisplay() {
		return String.valueOf(this.age);
	}


	public int getTimeOfTry() {
		return timeOfTry;
	}


	public void setTimeOfTry(int timeOfTry) {
		this.timeOfTry = timeOfTry;
	}


	public String getGrade() {
		if(score >=45 && score <=50)
			grade = "A";
		if(score >=35 && score <=44)
			grade = "B";
		if(score >=25 && score <=34)
			grade = "C";
		if(score <25)
			grade = "NC";
		return grade;
	}


	public boolean checkAnswer(String answer) {
		 int correctAnswer = Database.getAnswer(curQuestion);
		 int userAnswer = Integer.parseInt(answer);
		 if(userAnswer == correctAnswer)
		 {
			 if(timeOfTry == 1)
				 score += 10;
			 else if(timeOfTry == 2)
				 score += 5;
			 else if(timeOfTry == 3)
				 score += 2;
			 timeOfTry = 1; //reset
			 return true;
		 }
		 timeOfTry++;
		 return false;
	 }
	 
	 public String firstQuestion() {
		 return Database.getQuestion(0);
	 }
	 public String nextQuestion() {
		 curQuestion++;
		 return Database.getQuestion(curQuestion);
	 }
	 
	 public boolean finished() {
		 return curQuestion == Database.length();
	 }
	 public int getHighestScore() {
		 return Database.length()*10;
	 }
}
