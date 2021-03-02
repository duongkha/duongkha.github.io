<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>>The Number Quiz</title>
</head>
<body>
<p>Your score is: ${sessionScope.Quiz.getScore()}</p>
<span>You have completed the Number Quiz, with a score of ${sessionScope.Quiz.getScore()} out of ${sessionScope.Quiz.getNumofQuestions()}.</span>
</body>
</html>