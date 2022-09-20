<%@page import="com.ssafy.model.dto.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<%
	List<Dept> deptList = (List<Dept>)request.getAttribute("deptList");
%>
	<div class="container">
		 <div class="row mt-3">
		            <h2 class="bg-primary text-light text-center">부서 목록</h2>
		 </div>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<td>부서번호</td>
						<td>부서이름</td>
						<td>부서지역</td>
					</tr>
				</thead>
				<tbody>
<%
	if (deptList == null || deptList.size() == 0) {		%>
			<tr>
				<td colspan="3">등록된 부서정보가 없습니다.</td>
			</tr>
<%	} else {
		/* 반복문으로 뿌려주기 */
		for (Dept dept : deptList) {
%>
					<tr>
						<th><%=dept.getDeptNo() %></th>
						<th><a href="./detail.do?deptno=<%=dept.getDeptNo() %>"><%=dept.getDname() %></a></th>
						<th><%=dept.getLoc() %></th>
					</tr>
<% 		} 
	}%>
				</tbody>
			</table>
		
		</div>
		
	</div>
</body>
</html>