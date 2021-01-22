<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
out.println("welcome"+session.getAttribute("name"));
%></br>
<a href="CheckBalance">click here to check balance</a></br>
<a href="TransferMoney.html">click here to transfer money</a></br>
<a href="ResetPassword.html">click here to reset password</a></br>
</body>
</html>