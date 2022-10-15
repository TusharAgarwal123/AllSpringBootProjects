<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/CSS/style.css" />


</head>

<body>

	<div id="wrapper">


		<div id="header">

			<h2>CRM- Customer Relationship Manager</h2>

		</div>

		<div id="container">


			<div id="content">

				<table>

					<tr>

						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>


					</tr>

					<!-- loop over and print out customer -->

					<c:forEach var="cs" items="${customer}">

						<tr>

							<td>${cs.firstName }</td>
							<td>${cs.lastName }</td>
							<td>${cs.email }</td>

						</tr>


					</c:forEach>

				</table>

			</div>

		</div>


	</div>

</body>
</html>