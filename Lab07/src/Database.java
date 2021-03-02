
public class Database {
	private static String[] Questions= {
			 "3,1,4,1,5", //pi
			 "1,1,2,3,5", //fibonanci
			 "1,4,9,16,25" ,//square
			 "2,3,5,7,11", //primes
			 "1,2,4,8,16" //powers of 2
	 };
	 private static int[] answers= {9,8,36,13,32};
	 
	 public static String getQuestion(int index) {
		 if(index > -1 && index < Questions.length)
			 return Questions[index];
		 return null;
	 }
	 public static int getAnswer(int index) {
		 if(index > -1 && index < answers.length)
			 return answers[index];
		 return -1;
	 }
	 
	 public static int length() {
		 return Questions.length;
	 }
}
