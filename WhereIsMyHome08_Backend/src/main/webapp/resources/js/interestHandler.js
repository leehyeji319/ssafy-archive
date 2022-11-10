function registerInterest() {
	let dongcode = document.querySelector("#dong").value;
	const url = "/WhereIsMyHome08_Backend/interest/register.do?dongcode=" + dongcode;
	fetch(url)
		.then((response) => response.json())
		.then((data) => {
			if (data == true) {
				alert("관심지역 등록이 성공했습니다.");
			} else {
				alert("관심지역 등록이 실패했습니다.");
			}
		});
}

function getInterestAreas(kakaoMap) {
	const url = "/WhereIsMyHome08_Backend/interest/list.do";
	fetch(url)
		.then((response) => response.json())
		.then((data) => {
			let parents = document.querySelector("#interest-list-ul");
			let content = "";
			data.forEach((dong) => {
				let temp = `
                    <li>
           			 	<div class="interest-item" id="${dong.dongCode}" data-dongCode="${dong.dongCode}" data-dongName="${dong.dongName}" data-lat="${dong.lat}", data-lng="${dong.lng}" data-isMain="${dong.isMain}">
           			 		<div class="">
        			 			<h4 class="interest-item-value interest-item-dongname" value="${dong.dongCode}" style="display:inline">${dong.dongName}</h4>
        			 			<h4 style="display:inline">/</h4>
		                  		<h4 class="interest-item-value interest-item-gugunname" style="display:inline">${dong.gugunName}</h4>
           			 		</div>
	                          <div class="interest-item-buttons">
	                        	<button class="interest-item-setmain-btn btn-primary btn-sm" data-btn-dongCode="${dong.dongCode}">메인으로 변경</button>
	                        	<!-- <button class="btn btn-light btn-sm" id="interest-item-set-btn">삭제</button> -->
	                          </div>
		                </div>
           			</li> 
                         
						`;
				content += temp;
				if (dong.isMain == true) {
					kakaoMap.setCenter(new kakao.maps.LatLng(dong.lat, dong.lng));
				}
			});
			parents.innerHTML = content;
			/*
			document.querySelectorAll(".interest-item").forEach((item) => {
				item.addEventListener("click", () => {
					// TODO
					// 지도 데이터 갱신
					console.log(this.dataset);			
				})   	
				   });
				   */
			document.querySelectorAll(".interest-item-setmain-btn").forEach((item) => {
				let dongcode = item.parentNode.parentNode.dataset.dongcode

				item.addEventListener("click", () => {
					setMainArea(dongcode, kakaoMap);
					getLabel(dongcode);
				})
			})
		});
}

// 동코드, 좌표,
function setMainArea(dongcode, kakaoMap) {
	const url = "/WhereIsMyHome08_Backend/interest/setMain.do?dongcode=" + dongcode;
	fetch(url)
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
			if (data == true) {
//				alert("메인지역 변경이 성공했습니다.");
				getInterestAreas(kakaoMap)
			} else {
//				alert("메인지역 변경이 실패했습니다.");
			}
		})
}

function getLabel(dongcode) {
	const url = "/WhereIsMyHome08_Backend/interest/commercial.do?dongcode=" + dongcode;
	fetch(url)
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
			if (data != null) {
				console.log('getLabel 데이터 가져오기 성공');
				setLabel(data);
			} else {
				console.log('getLabel 데이터 가져오기 실패');
			}
		})
}

function setLabel(data) {
	let parents = document.querySelector("#label");
//	let content = `
//    	<div class="alert alert-primary position-absolute top-10 rounded bg-opacity-25 d-flex align-items-center fs-2" role="alert" style="z-index: 6;">`; 
   
   	let content = "";
   
   	if (data.label.labelId != null) {
        if (data.label.labelId === '001') {
			content += `
				&#127978;
			`;
		} else if (data.label.labelId === '002') {
			content += `
				&#128210;
			`;
		} else if (data.label.labelId === '003') {
			content += `
				&#127856;
			`;
		} else if (data.label.labelId === '004') {
			content += `
				&#127836;
			`;
		} else if (data.label.labelId === '005') {
			content += `
				&#128170;
			`;
		} else if (data.label.labelId === '006') {
			content += `
				&#128717;
			`;
		} 
	}
			
	content += `&nbsp;`;
	
	if (data.label.labelId == null) {
		content += `
			<div>
				이 지역은 중심 상권이 없습니다 &#128546;
			</div>
		`
	} else {
		content += `
			<div>
				이 지역은 <span class="fw-bolder">${ data.label.name }</span> 중심 상권입니다!
			</div>
		`;
	}
		
//	content += `</div>`;

	parents.innerHTML = content;
}

/*
function setLabel(data, kakaoMap) {
	// 오버레이로 올릴 이미지의 bounds를 받아 AbstractOverlay를 생성합니다.
	function GroundOverlay(bounds) {
		this.bounds = bounds;
		var node = this.node = document.createElement('div');
		node.className = 'node';

		//var img = this.img = document.createElement('img');
		//img.style.position = 'absolute';
		//img.src = imgSrc;

		var div = this.div = document.createElement('div');
		div.style.position = 'absolute';
		div.className = 'text-center fs-2';
		div.innerText = data.label.name + '입니다.';

		//node.appendChild(img);
		node.appendChild(div);
	}

	GroundOverlay.prototype = new kakao.maps.AbstractOverlay;

	GroundOverlay.prototype.onAdd = function() {
		var panel = this.getPanels().overlayLayer;
		panel.appendChild(this.node);
	};

	// 줌인 아웃 시 이미지를 원하는 bounds값에 맞게 표출하기 위해 img style을 정의 및 선언합니다.
	GroundOverlay.prototype.draw = function() {
		var projection = this.getProjection();
		var ne = projection.pointFromCoords(this.bounds.getNorthEast());
		var sw = projection.pointFromCoords(this.bounds.getSouthWest());

		var width = ne.x - sw.x;
		var height = sw.y - ne.y;

		this.node.style.top = ne.y + 'px';
		this.node.style.left = sw.x + 'px';
		this.node.style.width = width + 'px';
		this.node.style.height = height + 'px';
	}


	GroundOverlay.prototype.onRemove = function() {
		this.node.parentNode.removeChild(this.node);
	};


	// 해당 좌표는 예제 타일셋에서 projectionId: null로 선언이 되어 있기 때문에 pixel 좌표를 사용하였습니다.
	var sw = new kakao.maps.Coords(500, 0)
	ne = new kakao.maps.Coords(1000, -500);

	var bounds = new kakao.maps.CoordsBounds(sw, ne);

	var overlay = new GroundOverlay(bounds);
	overlay.setMap(kakaoMap);
}
*/



