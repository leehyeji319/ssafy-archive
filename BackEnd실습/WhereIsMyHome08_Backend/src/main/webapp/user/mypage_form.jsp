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
        /*window.onload = function () {
          document.querySelector("#okBtn").addEventListener("click", okMem);
          document.querySelector("#deleteMemBtn").addEventListener("click", deleteMem);
        }

        function okMem() {
            console.log("안됨")
            alert("수정되었습니다.")
            let url = "/index.html";
            location.href = url;
        }

        function modify() {
            let emailDisabled = document.querySelectorAll(".modify");
            // console.log(emailDisabled)
            emailDisabled.forEach(function (m) {
                let disabled = m.disabled;
                if (disabled) {
                    m.disabled = false;
                } else {
                    m.disabled = true;
                }
                m.value = "";
            })
        }

        function deleteMem() {
            clearStorage();
            alert("삭제되었습니다.")
            let url = "/index.html";
            location.href = url;
        }*/
    </script>
</head>


<div>

	<jsp:include page="/header.jsp" />


	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">회원 정보</h2>
		</div>
		<form method="post" action="${root}/user/update.do?userid=${user.userId}" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="userid">아이디</label></th>
						<td><input type="text" name="userid" id="userid" 
									value="${user.userId}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th><label for="password">비밀번호</label></th>
						<td><input type="password" name="password" id="password" 
									value="${user.userPwd}"/></td>
					</tr>
					<tr>
						<th><label for="name">이름</label></th>
						<td><input type="text" name="name" id="name" 
									value="${user.userName}"/></td>
					</tr>
					<tr>
						<th><label for="address">주소</label></th>
						<td><input type="text" name="address" id="address" 
									value="${user.address}"/></td>
					</tr>
					<tr>
						<th><label for="phone">번호</label></th>
						<td><input type="text" name="phone" id="phone" 
									value="${user.phone}"/></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정"/>
							<input type="submit" value="삭제" 
								formaction="${root}/user/delete.do?userid=${user.userId}" formmethod="post"/>							
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</div>

<jsp:include page="/footer.jsp" />

<!-- Bootstrap core JS-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>