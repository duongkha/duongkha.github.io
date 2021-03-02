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
		<p>Your score is: 0</p>
		<p>Guess the next number in the sequence</p>
		<p>${sessionScope.Quiz.getQuestion()}</p>
		<span>Your Answer:</span><input name='answer'/>
		<input type='submit' value='Submit'/>
	</form>
</body>
</html>