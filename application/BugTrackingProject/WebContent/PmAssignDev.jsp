<%@page import="java.util.ArrayList"%>
<%@page import="com.code.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/style1.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
td, th{
	text-align : center;
}
</style>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-4">
			<% List<User> userlist= (ArrayList<User>)request.getAttribute("userlist"); 
			int bugId=(int)request.getAttribute("bugId");%>
			<table class="table" border="2">
			<thead class="thead-dark"><tr><th>Developer Name</th></tr></thead>
			<%for(User user:userlist){ %>
				<tr><td><a href="AssignDev?userId=<%=user.getUserId()%>&bugId=<%=bugId%>"><%=user.getName()%></a></td></tr>
			<%} %>
			
			</table>			
		</div>
	</div>
</div>



</body>
</html>