<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/menu.jsp"/>
<!-- 스크립트에서 jstl쓰는거 아님. 스크립트안은 out.print임 스크립트 코드는 브라우저에서 실행되자나.. 
스크립트에 el을 넣은게 아니라 스크립트도 출력인거임 동작하면서 출력을 만들어내는것이 -->
<script>
	
	<c:if test="${not empty msg}">
		alert("${msg}");
		
	</c:if>
	
</script>





	<div class="container">
		 <div class="row mt-3">
		            <h2 class="bg-primary text-light text-center">부서 목록</h2>
		 </div>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>부서번호</th>
						<th>부서이름</th>
						<th>부서지역</th>
					</tr>
				</thead>
				<tbody>
				
				<c:choose>
					<c:when test="${empty deptList}">
						<tr> <td colspan="4">등록된 부서정보가 없습니다.</td></tr>
					</c:when> 
					<c:otherwise>
						<c:set var="no" value="1"/>
						<c:forEach items="${requestScope.deptList}" var="dept">
									<tr>
										<td>${no }</td>
										<td>${dept.deptNo}</td>
										<td><a href="${root}/dept/detail.do?deptno=${dept.deptNo}">${dept.dname}</a></td>
										<td>${dept.loc}</td>
									</tr>
							<c:set var="no" value="${no + 1}"/>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		
		</div>
		
	</div>
</body>
</html>