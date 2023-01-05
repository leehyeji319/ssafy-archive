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
function register() {
    if (confirm("공지를 등록하시겠습니까?")) {
        let title = document.querySelector("#title").value;
        let content = document.querySelector("#content").value;
         
  	  
  	  fetch('${root}/notice/update.do', {
  	      method: 'POST',
  	      headers: {
  	          'Content-Type': 'application/x-www-form-urlencoded'
  	      },
  	      body: new URLSearchParams({
  	    	  noticeId,
  	    	  title,
  	    	  content
  	        })
  	    }).then(response =>response.json())
  	      .then(flag => {
  	    	  if(flag){
  	    		  alert('공지 수정 성공');
  	    	  }else{
  	    		  alert('공지 수정 실패');
  	    	  }
      	      window.location.href = '${root}/notice/notice_detail.do?noticeid=${notice.noticeId}';
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

		<main class="mt-5 pt-5" style="width: 1000px; margin: 100px auto!important;">
    <div class="container-fluid px-4">
      <h1 class="mt-4">공지사항 등록</h1>
      <div class="card mb-4">
        <div class="card-body">
          <form method="post" action="${root}/notice/register.do" >
            <div class="mb-3">
              <label for="title" class="form-label">제목</label> <input
                type="text" class="form-control" id="title" name="title" required>
            </div>
            <div class="mb-3">
              <label for="title" class="form-label">작성자</label> <input
                type="text" class="form-control" id="admin" name="admin"
                value="관리자" disabled>
            </div>
            <div class="mb-3">
              <label for="content" class="form-label">내용</label>
              <textarea class="form-control" id="content" name="content" required /></textarea>
            </div>
            <a href="${root}/notice/notice.do" class="btn btn-outline-secondary">글 목록</a>
			<input type="submit" class="btn btn-outline-warning" value="등록" />
      
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