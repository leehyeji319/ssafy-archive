// 조회 요청 메소드
function getHouseList() {
	let dongcode = document.querySelector("#dong").value;
	
	if (dongcode != '') {
		let url = "/WhereIsMyHome08_Backend/house/list.do?dongcode="+dongcode;
  		location.href = url;
	} else {
		alert('동선택을 해주세요.');
	}
}

function getHouseDeals(url, latlng, aptName, kakaoMap) {
			  fetch(url)
			    .then((response) => response.json())
			    .then((data) => {
			    	let title = document.querySelector("#apt-list-title");
			    	title.innerHTML = `<h1 class="h1">거래 정보</h1>`;
			    	const h5 = document.createElement('h5');
			    	h5.innerHTML = aptName;
			    	title.appendChild(h5);
			    	
			    	let parents = document.querySelector("#apt-list-ul");
			    	let content = "";
			    	data.forEach((house) => {
			    		
						let temp = `
		          			<li>
		          			 	<div class="apt-item">
				                  <div class="apt-item-value apt-item-price">거래금액: ${house.dealAmount} 만원</div>
				                  <div class="apt-item-value apt-item-area">면적: ${house.area}</div>
				                  <div class="apt-item-value apt-item-date">거래일: ${house.dealYear}.${house.dealMonth}.${house.dealDay}</div>
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
