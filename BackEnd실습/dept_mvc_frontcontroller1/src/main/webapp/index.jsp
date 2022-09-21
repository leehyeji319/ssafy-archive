<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@ include file="/menu.jsp" %> --%>
	<jsp:include page="/menu.jsp"/>
	
	
	<ul>
		<li> <a href="${root}/dept/register_form.jsp">부서 등록</a> </li>
		<li> <a href="./dept/list.do">부서 목록 </a></li>
	</ul>
</body>
</html>