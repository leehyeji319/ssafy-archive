// 조회 요청 메소드 (동기) -> 비동기 수정
function getHouseList(kakaoMap) {
	let dongcode = document.querySelector("#dong").value;
	
	if (dongcode == '') {
		alert('동선택을 해주세요.');
		return;
	}
	
	let url = "/WhereIsMyHome08_Backend/house/list.do?dongcode="+dongcode;
	fetch(url)
		.then((response) => {
			if (response.url.endsWith("login_form.jsp")) {
				location.href = url;
				return;
			}	
			return response.json()
		})
		.then((data) => {
			if (data.length == 0) {
				alert('조회 결과가 존재하지 않는 지역입니다. 다른 지역을 선택해주세요.');
				return;
			}
	    	let title = document.querySelector("#house-list-title");
	    	title.innerHTML = "";
	    	
			let section = document.querySelector("#house-list");
			section.style.display = "block";
			
			// 리스트
			let parents = document.querySelector("#house-list-ul");
	    	let content = "";
			let houseList = [];
	    	data.forEach((house) => {
				let temp = `
              			<li>
              			 	<div class="house-item">
			                  <div class="house-item-value house-item-name">${house.aptName}</div>
			                  <div class="house-item-value house-item-price">거래금액: ${house.dealAmount}만원</div>
			                  <div class="house-item-value house-item-area">면적: ${house.area}</div>
			                  <div class="house-item-value house-item-date">거래일: ${house.dealYear}.${house.dealMonth}.${house.dealDay}</div>
			                </div>
              			</li>
				`;
				content += temp;
				
		        // 상세 조회에 사용할 데이터 추가 
	        	houseList.push({
	        		title: house.aptName,
	        		latlng: new kakao.maps.LatLng(house.lat, house.lng),
	        		dealAmount: house.dealAmount,
	        		aptcode: house.aptCode
	        	});
			});
	    	parents.innerHTML = content;
	    	
	    	let houseItems = document.querySelectorAll(".house-item");
	    	
	    	// 지도 초기화
			kakaoMap = kakaoMapInit();

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
				
				let url = "/WhereIsMyHome08_Backend/house/rest/deals.do?aptcode="+houseList[i].aptcode;
				let latlng = houseList[i].latlng;
				let aptName = houseList[i].title;
				kakao.maps.event.addListener(marker, 'click', function() {
					getHouseDeals(url, latlng, aptName, kakaoMap);
			    });
			    
    			// 리스트 클릭 시 상세 조회 이벤트리스너 추가
			    houseItems[i].addEventListener("click", () => {
					getHouseDeals(url, latlng, aptName, kakaoMap);
				})
			}
			
		    // 포커싱
	    	section.scrollIntoView();
	    	
		})
}


//상세조회 (비동기)
function getHouseDeals(url, latlng, aptName, kakaoMap, asc) {
			  fetch(url)
			    .then((response) => response.json())
			    .then((data) => {
			    	let title = document.querySelector("#house-list-title");
			    	title.innerHTML = `<h1 class="h1">거래 정보</h1>`;
			    	const h5 = document.createElement('h5');
			    	h5.innerHTML = aptName;
			    	title.appendChild(h5);
			    	
			    	const btns = document.createElement('div');
			    	btns.innerHTML = `
			    	<button type="submit" id="house-list-asc-btn" class="btn btn-sm btn-primary">거래금액 오름차순</button>
			    	<button type="submit" id="house-list-desc-btn" class="btn btn-sm btn-primary">거래금액 내림차순</button>
					`;
					title.appendChild(btns);
					
					const ascBtn = document.querySelector("#house-list-asc-btn");
					const descBtn = document.querySelector("#house-list-desc-btn");
					ascBtn.addEventListener("click", () => {
						getHouseDeals(url, latlng, aptName, kakaoMap, true);
					});
					descBtn.addEventListener("click", () => {
						getHouseDeals(url, latlng, aptName, kakaoMap, false);
					});
					
					if (asc == true) {
						data = quickSort(data, "dealAmount", true);
					} else if (asc == false) {
						data = quickSort(data, "dealAmount", false);
					}
					
			    	let parents = document.querySelector("#house-list-ul");
			    	let content = "";
			    	data.forEach((house) => {
			    		
						let temp = `
		          			<li>
		          			 	<div class="house-item">
				                  <div class="house-item-value house-item-price">거래금액: ${house.dealAmount} 만원</div>
				                  <div class="house-item-value house-item-area">면적: ${house.area}</div>
				                  <div class="house-item-value house-item-date">거래일: ${house.dealYear}.${house.dealMonth}.${house.dealDay}</div>
				                </div>
		          			</li>
						`;
						
						content += temp;
					});
			    	parents.innerHTML = content;
			    });
			  kakaoMap.setCenter(latlng);
			  kakaoMap.setLevel(3);
}

// 퀵소트 구현 배열, 정렬의 대상이되는 key, 오름차순/내림차순
function quickSort(array, key, asc) {
  if (array.length < 2) {
    return array;
  }
  const pivot = [array[0]];
  const left = [];
  const right = [];
  if (asc == true) {
	for (let i = 1; i < array.length; i++) {
	    if (array[i][key] < pivot[0][key]) {
	      left.push(array[i]);
	    } else if (array[i][key] > pivot[0][key]) {
	      right.push(array[i]);
	    } else {
	      pivot.push(array[i]);
	    }
	  }
	  return quickSort(left, key, true).concat(pivot, quickSort(right, key, true));
	} else {
		for (let i = 1; i < array.length; i++) {
		    if (array[i][key] > pivot[0][key]) {
		      left.push(array[i]);
		    } else if (array[i][key] < pivot[0][key]) {
		      right.push(array[i]);
		    } else {
		      pivot.push(array[i]);
		    }
		  }
	  return quickSort(left, key, false).concat(pivot, quickSort(right, key, false));
	}
  
}

//========셀렉트박스===========//
document.querySelector("#sido").addEventListener("change", function () {
  if (this[this.selectedIndex].value) {
    let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";
    sendRequest("gugun", regcode);
  } else {
    initOption("gugun");
    initOption("dong");
  }
});

// 구군이 바뀌면 동정보 얻기.
document.querySelector("#gugun").addEventListener("change", function () {
  if (this[this.selectedIndex].value) {
    let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
    sendRequest("dong", regcode);
  } else {
    initOption("dong");
  }
});


function sendRequest(selid, regcode) {
  const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
  let params = "regcode_pattern=" + regcode + "&is_ignore_zero=true";
  fetch(`${url}?${params}`)
    .then((response) => response.json())
    .then((data) => addOption(selid, data));
  // .then((data) => addOption(selid, data));
}

function addOption(selid, data) {
  let opt = ``;
  initOption(selid);
  switch (selid) {
    case "sido":
      opt += `<option value="">시도선택</option>`;
      data.regcodes.forEach(function (regcode) {
        opt += `
         <option value="${regcode.code}">${regcode.name}</option>
         `;
      });
      break;
    case "gugun":
      opt += `<option value="">구군선택</option>`;
      for (let i = 0; i < data.regcodes.length; i++) {
        if (i != data.regcodes.length - 1) {
          if (
            data.regcodes[i].name.split(" ")[1] == data.regcodes[i + 1].name.split(" ")[1] &&
            data.regcodes[i].name.split(" ").length != data.regcodes[i + 1].name.split(" ").length
          ) {
            data.regcodes.splice(i, 1);
            i--;
          }
        }
      }
      let name = "";
      data.regcodes.forEach(function (regcode) {
        if (regcode.name.split(" ").length == 2) name = regcode.name.split(" ")[1];
        else name = regcode.name.split(" ")[1] + " " + regcode.name.split(" ")[2];
        opt += `
         <option value="${regcode.code}">${name}</option>
         `;
      });
      break;
    case "dong":
      opt += `<option value="">동선택</option>`;
      let idx = 2;
      data.regcodes.forEach(function (regcode) {
        if (regcode.name.split(" ").length != 3) idx = 3;
        opt += `
         <option value="${regcode.code}">${regcode.name.split(" ")[idx]}</option>
         `;
      });
  }
  document.querySelector(`#${selid}`).innerHTML = opt;
}

function initOption(selid) {
  let options = document.querySelector(`#${selid}`);
  options.length = 0;
}
