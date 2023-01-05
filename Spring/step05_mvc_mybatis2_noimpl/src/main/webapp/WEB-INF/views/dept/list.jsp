<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- page directive�� �Ӽ��� �� ������ ��������������, import�� ���� �� ���� --%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
	<c:if test="${not empty msg}">
		<script>
			alert("${msg}");
		</script>
	</c:if>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	<div class = "container">
        <div class="row mt-3">
            <h2 class="bg-primary text-light text-center">�μ� ���</h2>
        </div>
        <div>
        	<span>�μ� �˻�</span>
        </div>
		<div class = "row">
			<table class = "table">
				<thead>
					<tr>
						<th>�μ���ȣ</th>			
						<th>�μ��̸�</th>			
						<th>�μ�����</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty deptList}">
							<tr><td colspan="3">��ϵ� �μ������� �����ϴ�.</td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${requestScope.deptList}" var="dept">
							<tr>
											<td>${dept.deptno}</td>			
						
										<%-- 	<td><a href="${root}/dept/detail.do?deptno=${dept.deptno}">${dept.dname}</a></td>	 --%>	
											<td><a href="${root}/dept/detail_with_emps.do?deptno=${dept.deptno}">${dept.dname}</a>	
											<td>${dept.loc}</td>
										</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>