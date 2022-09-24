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
function deleteNotice() {
    if (confirm("공지를 삭제하시겠습니까?")) {
    	let noticeId = document.querySelector("#noticeid").value;
    	console.log(noticeId);
  	  
  	  fetch('${root}/notice/delete.do', {
  	      method: 'POST',
  	      headers: {
  	          'Content-Type': 'application/x-www-form-urlencoded'
  	      },
  	      body: new URLSearchParams({
  	    	  noticeId
  	        })
  	    }).then(response =>response.json())
  	      .then(flag => {
  	    	  if(flag){
  	    		  alert('공지 삭제 성공');
  	    	  }else{
  	    		  alert('공지 삭제 실패');
  	    	  }
  	    	  window.location.href = '${root}/notice/notice.do';
  	      });
  	  
    } else {
        alert("취소!");
    }
}

</script>
</head>
<body>
	<div>

		<jsp:include page="/header.jsp" />

		<main class="mt-5 pt-5"
			style="width: 1000px; margin: 100px auto !important;">
			<div class="container-fluid px-4">
				<h1 class="mt-4">공지사항 ${notice.noticeId} 번</h1>
				<div class="card mb-4">
					<div class="card-body">
						<form>
							<div class="mb-3 mt-3">
								<label for="bno" class="form-label">번호</label> <input
									type="text" class="form-control" id="noticeid" name="noticeid"
									value="${notice.noticeId}" disabled>
							</div>
							<div class="mb-3">
								<label for="title" class="form-label">제목</label> <input
									type="text" class="form-control" id="title" name="title"
									value="${notice.title}" disabled>
							</div>
							<div class="mb-3">
								<label for="title" class="form-label">작성자</label> <input
									type="text" class="form-control" id="admin" name="admin"
									value="관리자" disabled>
							</div>
							<div class="mb-3">
								<label for="content" class="form-label">내용</label>
								<textarea class="form-control" id="content" name="content"
									disabled> ${notice.content}
								</textarea>
							</div>
							<div class="mb-3">
								<label for="regDate" class="form-label">날짜</label> <input
									type="text" class="form-control" id="datetime" name="datetime"
									value="${notice.date_time}" disabled>
							</div>
							<div class="mb-3">
								<label for="writer" class="form-label">조회수</label> <input
									type="text" class="form-control" id="writer" name="writer"
									value="${notice.hit}" disabled>
							</div>
							<a href="${root}/notice/notice.do"
								class="btn btn-outline-secondary">글 목록</a>
							<c:if test="${userid eq 'admin'}">
								<a href="${root}/notice/noticeUpdate_form.do?noticeid=${notice.noticeId}"
									class="btn btn-outline-warning">수정</a>
								<a class="btn btn-outline-danger" onclick="deleteNotice()">삭제</a>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</main>
		<!-- Footer-->
		<jsp:include page="/footer.jsp" />

		<!-- Bootstrap core JS-->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>