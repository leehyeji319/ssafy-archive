<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

<%-- 	<%@ include file="/menu.jsp" %> --%>
	<jsp:include page="/WEB-INF/views/menu.jsp"/>
	
	<ul>
		<li> <a href="${root}/dept/register_form.do">부서 등록 </a></li>
		<li><a href="${root}/dept/list.do">부서 목록</a></li>
		<li><a href="${root}/dept/rest/list.do">부서 목록 - JSON</a></li>
	</ul>
</body>
</html>










