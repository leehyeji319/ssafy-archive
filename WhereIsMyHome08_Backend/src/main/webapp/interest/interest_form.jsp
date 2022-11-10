<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
      rel="stylesheet"
      type="text/css"
    />
    <!-- Google fonts-->
    <link
      href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
      rel="stylesheet"
      type="text/css"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/WhereIsMyHome08_Backend/resources/css/styles.css" rel="stylesheet" />
    <script>
      window.onload = function () {
        sendRequest("sido", "*00000000");
        let registerBtn = document.querySelector("#form-house-list-btn");
        registerBtn.innerText = "등록";
        registerBtn.addEventListener("click", registerInterest);
      };
    </script>
  </head>

  <body>
    <div>
      <jsp:include page="/header.jsp" />

      <div class="container">
        <div class="row mt-3">
          <h2 class="bg-primary text-light text-center">관심 지역 등록</h2>
        </div>
        <c:if test="${errorMsg!=null}">
          <div class="row mt-3">
            <h2 class="bg-primary text-light text-center">${errorMsg }</h2>
          </div>
        </c:if>

        <jsp:include page="/house/select.jsp" />
      </div>
    </div>

    <!-- Footer-->
    <jsp:include page="/footer.jsp" />

    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    <script src="${root}/resources/js/searchHandler.js"></script>
    <script src="${root}/resources/js/interestHandler.js"></script>
  </body>
</html>
