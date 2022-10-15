<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Student is Confirmed : ${std.firstName } ${std.lastName }

	<br>
	<br> Country: ${std.country }
	<br>
	<br> Favourite Language: ${std.favouriteLanguage }
	<br>
	<br> Favourite OS:

	<ul>

		<c:forEach var="temp" items="${std.favouriteOS }">

			<li>${temp }</li>

		</c:forEach>

	</ul>



</body>
</html>