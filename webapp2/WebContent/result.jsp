<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- result.jsp -->
<%@page import="webapp2.EmpBean" %>
<%webapp2.EmpBean eb1=(webapp2.EmpBean)request.getAttribute("res"); %><br><br>
<table>
<tr>
<td><%=eb1.getId() %></td>
<td><%=eb1.getAddress() %></td>
</tr>
</table>
</body>
</html>