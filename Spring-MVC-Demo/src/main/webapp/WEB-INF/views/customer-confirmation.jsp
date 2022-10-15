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
	The Customer is confirmed: ${customer.firstName } ${customer.lastName }

	<br>
	<br> Free Passes: ${customer.freePasses }

	<br>
	<br> Postal Code: ${customer.postalCode }

	<br>
	<br> Course Code: ${customer.courseCode }


</body>
</html>