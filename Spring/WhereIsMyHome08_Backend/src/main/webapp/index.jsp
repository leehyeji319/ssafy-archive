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
    <link href="/WhereIsMyHome08_Backend/resources/css/house-list.css" rel="stylesheet" />
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=980bea8bcd07009e77637df27e1433d7"
    ></script>
    <script>
      window.onload = function () {
        let kakaoMap = kakaoMapInit();
        // 주소 셀렉트박스 초기화
        sendRequest("sido", "*00000000");
        // 조회 버튼 이벤트리스너
        document.querySelector("#form-house-list-btn").addEventListener("click", () => {getHouseList(kakaoMap)});
      };
    </script>
</head>
<body>

	<jsp:include page="/header.jsp"/>

    <!-- Masthead-->
    <section class="masthead">
      <div class="container-fluid position-relative">
        <div class="row justify-content-center">
          <div class="col-xl-6">
            <div class="text-center text-white">
              <!-- Page heading-->
              <h1 class="mb-5">
                구해줘 홈즈<!DOCTYPE html>
                <html lang="en">
                  <head>
                    <meta charset="UTF-8" />
                    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <title>Document</title>
                  </head>
                  <body></body>
                </html>
              </h1>
              
              
             <jsp:include page="/house/select.jsp"/>

            </div>
          </div>
        </div>
      </div>
    </section>

	<jsp:include page="/house/list.jsp"/>
	
    <!-- Footer-->
    <jsp:include page="/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    <script src="${root}/resources/js/mapHandler.js"></script>
    <script src="/WhereIsMyHome08_Backend/resources/js/searchHandler.js"></script>
  </body>
</html>