<%@ page session="true" %>
<html>
 <head>
 <title>Choose</title>
 </head>
 <body>
  <%
  System.out.println(session.getAttribute("JSFwayCool"));
  %>
 <form method='post' action='ChooseServlet'>
 <p>Is JSP cool?</p>

 <input type='radio' value='1' name='radioJSPCool' ${sessionScope.radioJSPCoolYes}><span>Yes</span><br/>
 <input type='radio' value='0' name='radioJSPCool' ${sessionScope.radioJSPCoolNo}><span>No</span><br/>
 <input type='submit' name='btnSubmit' value='Submit'/>
 <p>Is JSF way cool?</p>
 <input type='radio' value='1' name='JSFwayCool' ${sessionScope.JSFwayCool.getYesCheck()}><span>Yes</span><br/>
 <input type='radio' value='0' name='JSFwayCool' ${sessionScope.JSFwayCool.getNoCheck()}><span>No</span><br/>
 <input type='submit' name='btnSubmit' value='Submit'/>
 <p>Is the moon made of cheese?</p>
 <input type='radio' value='1' name='moonCheese' ${sessionScope.moonCheese.getYesCheck()}><span>Yes</span><br/>
 <input type='radio' value='0' name='moonCheese' ${sessionScope.moonCheese.getNoCheck()}><span>No</span><br/>
 <input type='submit' name='btnSubmit' value='Submit'/>
 </form>
 </body>
</html>
