<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="get" action="processForm2" modelAttribute="user">


 Name: <form:input path="name" />
		<br>
		<br>
 
 RollNo: <form:input path="rollNo" />
		<br>
		<br>
		
 Email: <form:input path="email" />
		<br>
		<br>		
 
 Password: <form:input path="password" />
		<br>
		<br>
 
 Gender:Male<form:radiobutton path="gender" value="Male" />
	  Female<form:radiobutton path="gender" value="Female" />
		<br>
		<br>
		
  
 City: <form:input path="city" />
		<br>
		<br>
		
PinCode: <form:input path="pinCode" />
		<br>
		<br>


		<input type="submit" value="Register">


	</form:form>


</body>
</html>