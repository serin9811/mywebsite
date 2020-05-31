<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
//1.세션이 있는지 없는 지 확인
String name=(String)session.getAttribute("id");

//1.1.세션 있으면 보드 내용 뿌려준다
//1.2. 세션 없으면 loginForm으로 보내주는데, requestURL를 남겨서 다시 돌아올 수 있도록
if(name == null){
	response.sendRedirect("loginForm.jsp?url="+request.getRequestURI());
}
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
<jsp:include page="map.jsp" flush="false"/>
<h1>Board</h1>
</body>
</html>