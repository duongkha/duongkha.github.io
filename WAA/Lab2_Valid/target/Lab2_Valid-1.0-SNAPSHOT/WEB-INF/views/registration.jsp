<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
    <title>Registration</title>
</head>
<body>
    <h1>Registration Form</h1><br />
    <div id="global">
        <form:form modelAttribute="student" action="registration" method="post">
            <fieldset>
                <legend>Registration</legend>
                <p>
                    <form:errors path="*" cssStyle="color : red;" />
                </p>
                <p>
                    <label for="firstName">First Name: </label>
                        <form:input path="firstName" />
                <div style="text-align: center;">
                    <form:errors path="firstName" cssStyle="color : red;" />
                </div>
                </p>
                <p>
                    <label for="lastName">Last Name: </label>
                        <form:input path="lastName" />
                <div style="text-align: center;">
                    <form:errors path="lastName" cssStyle="color : red;" />
                </div>
                </p>

                <p>
                    <label for="email">Email: </label>
                    <form:input path="email" id="email" />
                    <form:errors path="email" cssStyle="color : red;" />
                </p>
                <p>
                    <label for="gender">Gender </label>
                    <form:select id="gender" path="gender" name="gender">
                        <option value=""> --Select Gender--</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </form:select>
                    <form:errors path="gender" cssStyle="color : red;" />
                </p>
                <p>
                    <label for="birthday">DOB: </label>
                    <form:input path="birthday" id="birthday" type="date"/>
                    <form:errors path="birthday" cssStyle="color : red;" />
                </p>
                <p>
                    <label for="phone">Phone: </label>
                    <form:input path="phone.area" id="area" />
                    <form:input path="phone.prefix" id="prefix" />
                    <form:input path="phone.number" id="number" />
                    <form:errors path="phone" cssStyle="color : red;" />
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="4">
                    <input id="submit" type="submit" tabindex="5" value="Register">
                </p>
            </fieldset>
        </form:form>
    </div>
</body>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
</body>
</html>