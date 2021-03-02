<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Number Quiz</title>
</head>
<body>
	<form method='post'>
		<p>Your Age:</p>
		<p style="color:red">${sessionScope.AgeError}</p>
		<input type="number" name="age" value="${sessionScope.Age}">
		<p>Your score is: ${sessionScope.Quiz.getScore()}</p>
		<p style="color:red;font-weight:Bold">${sessionScope.TryAgain}</p>
		<p>Guess the next number in the sequence</p>
		<p>${sessionScope.Quiz.getQuestion()}</p>
		<span>Your Answer:</span><input name='answer'/>
		<input type='submit' value='Submit'/>
		<p><input type="button" onclick="window.open(
			  'http://argon.cs.mum.edu/JSPintroQuizLab/',
			  '_blank'
			);" value="Hint?" /></p>
	</form>
</body>
</html>