<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container">
	
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">로그인</h2>
		</div>
		<c:if test="${errorMsg!=null }">
			<div class="row mt-3">
				<h2 class="bg-primary text-light text-center">${errorMsg }</h2>
			</div>
		</c:if>
		
		<form method="post" action="${root}/user/login.do" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="userId">아이디</label></th>
						<td><input type="text" name="userId" id="userId"/></td>
					</tr>
					<tr>
						<th><label for="password">비밀번호</label></th>
						<td><input type="password" name="password" id="password"/></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
<%@ include file="/include/footer.jsp" %>