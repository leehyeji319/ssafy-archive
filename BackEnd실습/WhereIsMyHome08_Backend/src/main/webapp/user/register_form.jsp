<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" type="text/css" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/WhereIsMyHome08_Backend/resources/css/styles.css"
	rel="stylesheet" />
<script>
	$(document).ready(function() {
	 $("#registerBtn").click(function() {
	
	 if($("#username").val() == "") {
	 alert("이름 입력!!!");
	 return;
	 } else if($("#userid").val() == "") {
	 alert("아이디 입력!!!");
	 return;
	 } else if($("#userpwd").val() == "") {
	 alert("비밀번호 입력!!!");
	 return;
	 } else if($("#userpwd").val() != $("#pwdcheck").val()) {
	 alert("비밀번호 확인!!!");
	 return;
	 }
	 });
	
	 });
</script>
</head>
<body>
	<div>

		<jsp:include page="/header.jsp" />

		<div class="container">
			<div class="row mt-3">
				<h2 class="bg-primary text-light text-center">회원 가입</h2>
			</div>

			<c:if test="${errorMsg != null} ">
				<div class="row mt-3">
					<h4 class="bg-warning text-light text-center">${errorMsg}</h4>
				</div>
			</c:if>

			<form method="post" action="${root}/user/register.do" class="row">
				<table class="table">
					<tbody>
						<tr>
							<th><label for="userid">아이디 입력</label></th>
							<td><input type="text" name="userid" id="userid" /></td>
						</tr>
						<tr>
							<th><label for="userpwd">비밀번호 입력</label></th>
							<td><input type="password" name="userpwd" id="userpwd" /></td>
						</tr>
						<tr>
							<th><label for="userpwdcheck">비밀번호 확인</label></th>
							<td><input type="password" name="userpwdcheck" id="userpwdcheck" /></td>
						</tr>
						<tr>
							<th><label for="username">이름 입력</label></th>
							<td><input type="text" name="username" id="username" /></td>
						</tr>
						<tr>
							<th><label for="address">주소 입력</label></th>
							<td><input type="text" name="address" id="address" /></td>
						</tr>
						<tr>
							<th><label for="phone">번호 입력</label></th>
							<td><input type="text" name="phone" id="phone" /></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><input type="submit" value="가입" /> <input
								type="reset" value="초기화" /></td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>

		<!-- Footer-->
		<jsp:include page="/footer.jsp" />

		<!-- Bootstrap core JS-->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>