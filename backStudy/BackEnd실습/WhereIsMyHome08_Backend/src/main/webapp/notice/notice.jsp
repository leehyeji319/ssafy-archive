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
	
</script>
</head>
<body>
	<div>

		<jsp:include page="/header.jsp" />

		<div class="body"
			style="padding: 200px 20%; background-color: rgb(245, 248, 253);">
			<h2 style="text-align: center; margin-bottom: 50px;">공지사항</h2>
			
			<c:if test="${userid eq 'admin'}">
				<div style="text-align: right;">
					<input type="button" value="공지사항 등록"
						onclick="location.href='${root}/notice/register_form.do'" />
			</c:if>
					<c:if test="${usrid eq 'admin'}">
						<div style="text-align: right;">
							<input type="button" value="공지사항 등록"
								onclick="location.href='${root}/notice/register.do'" />
						</div>
					</c:if>

					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>날짜</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty notices }">
									<tr>
										<td colspan="4">등록된 공지사항이 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${requestScope.notices}" var="notice"
										varStatus="status">
										<tr>
											<td>${notice.noticeId}</td>
											<td><a
												href="${root}/notice/notice_detail.do?noticeid=${notice.noticeId}">${notice.title}</a></td>
											<td>관리자</td>
											<td>${notice.date_time}</td>
											<td>${notice.hit}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>

				<!-- Footer-->
				<jsp:include page="/footer.jsp" />

				<!-- Bootstrap core JS-->
				<script
					src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
				<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>