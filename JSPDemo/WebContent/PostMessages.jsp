<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title> Introduction to JSP demo – postback page </title>
 </head>
 <body>
 <p><%! int count = 0; %>
 The count is now:
 <%= ++count %>

 <%-- This is a jsp scriptlet that increments the count --%>
 <!-- This is an html comment inserted by the increment comment -->
 <% count = count * 10; %>
 The count is now:
 <%= count %>
</p>
 </body>
</html>