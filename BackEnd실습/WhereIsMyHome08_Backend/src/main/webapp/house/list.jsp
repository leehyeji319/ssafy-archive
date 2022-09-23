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
    <link href="/WhereIsMyHome08_Backend/resources/css/searchHouse.css" rel="stylesheet" />
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=980bea8bcd07009e77637df27e1433d7"
    ></script>
    <script>
      window.onload = function () {
        let kakaoMap = kakaoMapInit();
        sendRequest("sido", "*00000000");
        // 조회 버튼 이벤트리스너
        document.querySelector("#form-house-list-btn").addEventListener("click", getHouseList);
        document.querySelectorAll(".apt-item").forEach((element) => {
          element.addEventListener("click", function () {
            setCenter(kakaoMap, element);
          });
        });
      };
    </script>
</head>
<body>
    <jsp:include page="/header.jsp"/>

    <section>
      <div class="container-fluid position-relative" id="search-bar">
        <div class="row justify-content-center">
          <div class="col-xl-6">
            <div class="text-center text-white justify-content-center">
              <!-- Page heading-->

              <jsp:include page="/commons/houseSelect.jsp"/>
              
            </div>
          </div>
        </div>
      </div>
    </section>

    <section>
      <div class="container h-auto">
        <div class="row" style="border: 1px solid">
          <div class="col">
            <div>
              <h1 class="h1">거래 정보</h1>
              
              <div id="apt-list">
              	<ul>
              		<c:forEach var="house" items="${requestScope.houseList}">
              			<li>
              			 	<div class="apt-item">
			                  <div class="apt-item-value apt-item-name">${house.aptName}</div>
			                  <div class="apt-item-value apt-item-price">거래금액: ${house.dealAmount}만원</div>
			                  <div class="apt-item-value apt-item-area">면적: ${house.area}</div>
			                  <div class="apt-item-value apt-item-date">${house.dealYear} ${house.dealMonth} ${house.dealDay}</div>
			                </div>
              			</li>
              		</c:forEach>
              	</ul>
               
              </div>
            </div>
          </div>
          <div class="col">
            <div id="map" style="width: 800px; height: 800px"></div>
          </div>
        </div>
      </div>
    </section>

    <!-- Footer-->
    <jsp:include page="/footer.jsp"/>
    
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    <script src="/WhereIsMyHome08_Backend/resources/js/searchHandler.js"></script>
    <script src="/WhereIsMyHome08_Backend/resources/js/mapHandler.js"></script>
  </body>
</html>