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
		} else {
			$("#userform").attr("action", "${root}/index.do").submit();
		}
	});
	 
	$('#zipcode').focusin(function() {
		$('#zipModal').modal();
	});
});
</script>
</head>
<body>
	<div>

		<jsp:include page="/header.jsp" />

		<div class="container" align="center">
			<div class="col-lg-6" align="center">
				<form id="userform" method="post" action="">
					<input type="hidden" name="act" id="act" value="register">
					<div class="form-group" align="left">
						<label for="name">이름</label> <input type="text"
							class="form-control" id="username" name="username" placeholder="">
					</div>
					<div class="form-group" align="left">
						<label for="">아이디</label> <input type="text" class="form-control"
							id="userid" name="userid" placeholder="">
					</div>
					<div class="form-group" align="left">
						<label for="">비밀번호</label> <input type="password"
							class="form-control" id="userpwd" name="userpwd" placeholder="">
					</div>
					<div class="form-group" align="left">
						<label for="">비밀번호재입력</label> <input type="password"
							class="form-control" id="pwdcheck" name="pwdcheck" placeholder="">
					</div>
					<div class="form-group" align="left">
						<label for="">주소</label><br> <input type="text"
							class="form-control" id="address" name="address" placeholder="">
					</div>
					<div class="form-group" align="center">
						<button type="button" class="btn btn-primary" id="registerBtn">회원가입</button>
						<button type="reset" class="btn btn-warning">초기화</button>
					</div>
				</form>
			</div>
		</div>

		<!-- Footer-->
		<jsp:include page="/footer.jsp" />

		<!-- Bootstrap core JS-->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>