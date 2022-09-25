<%@page import="java.util.ArrayList"%>
<%@page import="com.code.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/style1.css">
</head>
<body>
  <%List<User> ulist=(ArrayList<User>)request.getAttribute("ulist"); %>
  <table>
  <tr><td>Project Name : </td><td><input type="text" name="nm" id="name" autofocus required placeholder="Enter project name"></td><td></td></tr>
    <tr><td>Start date : </td><td><input type="date" name="jdt" id="dt"  required placeholder="Enter date"></td><td></td></tr>
    <tr><td>Description :</td><td><textarea rows="3" cols="20" name="description" id="desc"></textarea></td></tr>
    <tr><td>
    <%for(User u:ulist){ %>   
      <input type="checkbox" name="user" id="<%=u.getName()%>" value=""><%=u.getName()%><br>
    <%}; %>
    
    </td></tr>
  </table>
</body>
</html>