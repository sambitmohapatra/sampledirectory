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
<%@page import="webapp3.EmpBean" %>
<%webapp3.EmpBean eb1=(webapp3.EmpBean)request.getAttribute("res"); %><br><br>
<table>
<tr>
<td><%=eb1.getId() %></td>
<td><%=eb1.getAddress() %></td>
</tr>
</table>
<form name="form1" method="get" action="Appjson">
<input type="submit" value="download json">
</form>
<form name="form2" method="get" action="Appcsv">
<input type="submit" value="download csv">
</form>
</body>
</html>