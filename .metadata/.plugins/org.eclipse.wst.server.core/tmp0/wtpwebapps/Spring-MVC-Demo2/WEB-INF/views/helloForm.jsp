<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.error {
	color: red
}
</style>
</head>
<body>

	<form:form action="processForm" modelAttribute="std">
	
	
	First Name(*):<form:input path="firstName" />
		<form:errors path="firstName" cssClass="error"></form:errors>
		<br>
		<br>
	
	Last Name(*):<form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"></form:errors>
		<br>
		<br>
	
	Roll No(*):<form:input path="rollNo" />
		<form:errors path="rollNo" cssClass="error"></form:errors>
		<br>
		<br>
	
	Course Name(*):<form:input path="courseName" />
		<form:errors path="courseName" cssClass="error"></form:errors>
		<br>
		<br>

		<input type="submit" value="Submit">

	</form:form>

</body>
</html>