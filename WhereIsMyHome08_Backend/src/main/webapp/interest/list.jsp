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
    <link href="/WhereIsMyHome08_Backend/resources/css/interest-list.css" rel="stylesheet" />
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=09d68f8b4066102767890f0f00a4c0cd"
    ></script>
    <script>
      window.onload = function () {
        let kakaoMap = kakaoMapInit();
        getInterestAreas(kakaoMap);
      }; 
    </script>
</head>
<body>
    <jsp:include page="/header.jsp"/>

    <section>
      <div class="container h-auto">
        <div class="row" style="height: 700px; border: 1px solid">
        
          <div class="col" style="overflow: scroll; height: 100%;" >
            <div>
            	<div id="interest-list-title">
              		<h1 class="h1">관심 지역 목록</h1>
            	</div>
         
              <div>
              	<ul id="interest-list-ul">
                    <h3>관심지역을 등록해주세요.</h3>
              	</ul>
               
              </div>
            </div>
          </div>
          
          <div class="col h-auto">
            <div class="position-relative" id="map" style="width: 800px; height: 100%; z-index: 3;">
				<div id="label" class="alert alert-primary position-absolute top-10 rounded bg-opacity-25 d-flex align-items-center fs-2" role="alert" style="z-index: 6;">
				</div>
            </div>
          </div>
          
        </div>
      </div>
    </section>
    
    <!-- Footer-->
    <jsp:include page="/footer.jsp"/>
    
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    <script src="${root}/resources/js/searchHandler.js"></script>
    <script src="${root}/resources/js/mapHandler.js"></script>
    <script src="${root}/resources/js/interestHandler.js"></script>
  </body>
</html>