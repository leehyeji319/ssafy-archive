function kakaoMapInit() {
  var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
  var options = {
    //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(37.5125702, 127.1025625), //지도의 중심좌표.
    level: 5, //지도의 레벨(확대, 축소 정도)
  };

  var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
  
  // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	var mapTypeControl = new kakao.maps.MapTypeControl();
	
	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	
	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

  return map;
}

// 선택한 아이템의 좌표를 전달 받아 지도의 중심을 이동하는 함수
// 임시로 id를 이용하여 임의의 좌표로 이동함
function setCenter(kakaoMap, element) {
  let temp = 127.1025625 + parseInt(element.getAttribute("data")) / 1000;
  let moveLatLon = new kakao.maps.LatLng(37.5125702, temp);
  kakaoMap.setCenter(moveLatLon);
}
