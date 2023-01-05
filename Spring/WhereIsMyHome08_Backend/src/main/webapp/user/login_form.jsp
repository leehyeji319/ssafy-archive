<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
/*	window.onload = function() {
		document.querySelector("#loginBtn").addEventListener("click",
				totalCheck);
	};

	function totalCheck() {
		let id = document.getElementById("inputEmail").value;
		let pw = document.getElementById("inputPassword").value;

		if (!(id && pw)) {
			alert("올바르지 않은 ID/PW 입력값입니다.");
		} else {
			loginBtn()
			function loginBtn() {
				setStateLogin();
				alert("로그인되었습니다.")
				let url = "/index.jsp";
				location.href = url;
			}
		}
	} */
</script>
</head>

<body>
	<div>

		<jsp:include page="/header.jsp" />

		<div class="container">

			<div class="row mt-3">
				<h2 class="bg-primary text-light text-center">로그인</h2>
			</div>
			<c:if test="${errorMsg!=null}">
				<div class="row mt-3">
					<h2 class="bg-primary text-light text-center">${errorMsg }</h2>
				</div>
			</c:if>

			<form method="post" action="${root}/user/login.do" class="row">
				<table class="table">
					<tbody>
						<tr>
							<th><label for="userid">아이디</label></th>
							<td><input type="text" name="userid" id="userid" /></td>
						</tr>
						<tr>
							<th><label for="password">비밀번호</label></th>
							<td><input type="password" name="userpwd" id="userpwd" /></td>
						</tr>
					</tbody>
					<tfoot> 
						<tr>
							<td colspan="2"><input type="submit" value="로그인" /> <input
								type="reset" value="취소" /></td>
						</tr>
					</tfoot>
				</table>
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