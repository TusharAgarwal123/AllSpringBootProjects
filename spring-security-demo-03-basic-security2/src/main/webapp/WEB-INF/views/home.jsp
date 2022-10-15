<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Hello Everyone....How are you</h1>

	<hr>

	<!-- display username and their roles -->

	<P>

		User:
		<security:authentication property="principal.username" />
		<br> <br> Role:
		<security:authentication property="principal.authorities" />

	</P>

	<hr>

	<br>
	<br>

	<!-- only show this section with user role batsman -->

	<security:authorize access="hasRole('Batsman')">


		<!-- add a link to point to /leaders..this is for the Batsman -->

		<P>

			<a href="${pageContext.request.contextPath }/leaders">Leadership
				Meeting</a> (Only for the Batsman Role)

		</P>

	</security:authorize>


	<!-- only show this section with user role Designer -->

	<security:authorize access="hasRole('Designer')">

		<!-- add a link to point to /admin..this is for the Designer -->

		<P>

			<a href="${pageContext.request.contextPath }/admin">Admins
				Meeting</a> (Only for the Designer Role)

		</P>

	</security:authorize>


	<!--  


	<form:form action="${pageContext.request.contextPath }/logout"
		method="POST">


		<input type="submit" value="LogOut">

	</form:form>  -->



</body>
</html>