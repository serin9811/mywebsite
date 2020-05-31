<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1.세션에 세션 아이디 있는지 없는지 확인
String name=(String)session.getAttribute("id");
String url=request.getParameter("url");
//1.1 세션 아이디 있다면 이미 로그인 되었다는 걸 의미 그러므로 로그아웃시켜줘야함
if(name !=null){
	session.invalidate();
	System.out.println("Signed out!");
} 
//로그인 한 후에 이동시켜줘야 할 페이지 
url= url !=null ? url: "index.jsp";

//
%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<jsp:include page="map.jsp" flush="false"/>
<form action="/LoginAction">
ID:<input name="id" type="text"><br>
PW:<input name="pwd" type="password">
<input type="submit" value="OK"><br>
<label><input type="hidden" value =<%=url%> name="url"></label>

</form>

</body>
</html>