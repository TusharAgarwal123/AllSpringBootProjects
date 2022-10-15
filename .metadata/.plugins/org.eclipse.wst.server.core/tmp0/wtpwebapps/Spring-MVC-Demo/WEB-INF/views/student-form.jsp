<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="std">
 
 
FirstName:   <form:input path="lastName" />



		<br>
		<br>

lastName:   <form:input path="lastName" />



		<br>
		<br>

	Country:	<form:select path="country">




			<form:option value="In" label="India"></form:option>
			<form:option value="Br" label="Brazil"></form:option>
			<form:option value="Nep" label="Nepal"></form:option>


		</form:select>

		<br>
		<br>
		Favourite Language:
		
		Java<form:radiobutton path="favouriteLanguage" value="Java" />
		Ruby<form:radiobutton path="favouriteLanguage" value="Ruby" />
		C#<form:radiobutton path="favouriteLanguage" value="C#" />

		<br>
		<br>
		
		Operating System:
		
		Linux<form:checkbox path="favouriteOS" value="Linux" />
		Mac Os<form:checkbox path="favouriteOS" value="Mac Os" />
		Windows<form:checkbox path="favouriteOS" value="Windows" />

		<br>
		<br>

		<input type="submit" value="submit">

	</form:form>

</body>
</html>