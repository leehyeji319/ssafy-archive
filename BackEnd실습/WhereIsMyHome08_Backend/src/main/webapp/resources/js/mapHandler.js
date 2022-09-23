function kakaoMapInit() {
  var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
  var options = {
    //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(37.5125702, 127.1025625), //지도의 중심좌표.
    level: 3, //지도의 레벨(확대, 축소 정도)
  };

  var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
  return map;
}

// 선택한 아이템의 좌표를 전달 받아 지도의 중심을 이동하는 함수
// 임시로 id를 이용하여 임의의 좌표로 이동함
function setCenter(kakaoMap, element) {
  let temp = 127.1025625 + parseInt(element.getAttribute("data")) / 1000;
  let moveLatLon = new kakao.maps.LatLng(37.5125702, temp);
  kakaoMap.setCenter(moveLatLon);
}
