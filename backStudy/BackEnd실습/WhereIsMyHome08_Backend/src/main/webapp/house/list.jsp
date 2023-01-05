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
        
        // 마커 찍기
        
        // 마커를 표시할 위치와 title 객체 배열입니다 
		let houseList = [];
        <c:forEach var="house" items="${requestScope.houseList}">
        	houseList.push({
        		title: "${house.aptName}",
        		latlng: new kakao.maps.LatLng("${house.lat}", "${house.lng}"),
        		dealAmount: "${house.dealAmount}",
        		aptcode: "${house.aptCode}"
        	});
        </c:forEach>

		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		kakaoMap.setCenter(houseList[0].latlng);
		for (var i = 0; i < houseList.length; i ++) {
		    
		    // 마커 이미지의 이미지 크기 입니다
		    var imageSize = new kakao.maps.Size(24, 35); 
		    
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		    
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: kakaoMap, // 마커를 표시할 지도
		        position: houseList[i].latlng, // 마커를 표시할 위치
		        title : houseList[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image : markerImage // 마커 이미지 
		    });
		    
		    let iwContent = houseList[i].dealAmount;
		    let iwPosition = houseList[i].latlng; //인포윈도우 표시 위치입니다

			// 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({
			    position : iwPosition, 
			    content : iwContent 
			});
		    
			infowindow.open(kakaoMap, marker); 
			
			let url = "${root}/house/rest/deals.do?aptcode="+houseList[i].aptcode;
			let latlng = houseList[i].latlng;
			let aptName = houseList[i].title;
			kakao.maps.event.addListener(marker, 'click', function() {
				getHouseDeals(url, latlng, aptName, kakaoMap);
		    });
		}
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

              <jsp:include page="/houseSelect.jsp"/>
              
            </div>
          </div>
        </div>
      </div>
    </section>

    <section>
      <div class="container h-auto">
        <div class="row" style="height: 700px; border: 1px solid">
        
          <div class="col" style="overflow: scroll; height: 100%;" >
            <div>
            	<div id="apt-list-title">
              		<h1 class="h1">거래 정보</h1>
            	</div>
         
              <div>
              	<ul id="apt-list-ul">
              		<c:forEach var="house" items="${requestScope.houseList}">
              			<li>
              			 	<div class="apt-item">
			                  <div class="apt-item-value apt-item-name">${house.aptName}</div>
			                  <div class="apt-item-value apt-item-price">거래금액: ${house.dealAmount}만원</div>
			                  <div class="apt-item-value apt-item-area">면적: ${house.area}</div>
			                  <div class="apt-item-value apt-item-date">거래일: ${house.dealYear}.${house.dealMonth}.${house.dealDay}</div>
			                </div>
              			</li>
              		</c:forEach>
              	</ul>
               
              </div>
            </div>
          </div>
          
          <div class="col h-auto">
            <div id="map" style="width: 800px; height: 100%"></div>
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
  </body>
</html>