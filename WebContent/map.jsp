<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String stateOfLog="";
String name=(String)session.getAttribute("id");

if(name !=null){
	stateOfLog="Sign out";
} else{
	stateOfLog="Sign in";
}
%>
<html>
<head>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<div class="topnav">
  <a class="active" href="/index.jsp">Home</a>
  <a href="/board.jsp">Board</a>
  <a href="/lecture.jsp">Lecture</a>
  <a href="/loginForm.jsp"><%=stateOfLog%></a>
</div>
</body>
</html>