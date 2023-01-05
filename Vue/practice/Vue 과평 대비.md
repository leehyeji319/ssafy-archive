# Vue 과평 대비

# 1. MVVM 패턴 - Model + View + ViewModel

- Model: 순수자스
- View: 웹페이지 dom
- ViewModel: Vue 역할
- 양방향 통신 가능

# 2. Vue Instance 생성

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled.png)

- el: Vue가 적용될 요소 지정. View 쪽임
- data: model. 객체 또는 함수형태
- template: 화면에 표시할 html, css 마크업 요소 정의하는 속성. 뷰의 데이터 및 기타 속성들도 함께 화면에 그릴 수 있음
- methods: 화면 로직 제어와 관계된 method를 정의하는 속성. 이벤트처리하는거. 화면의 전반적인 이벤트와 화면 동작과 관련된 로직 추가
- created: 뷰 인스턴스가 생성되자마자 실행할 로직 정의

- Vue Instance 유효범위
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%201.png)
    
    이 밖으로 나가면 걍 text로 인식됨
    

# 3. Vue Instance Life Cycle

- beforeCreate: 뷰인스턴스 생성되고 정보의 설정 전에 호출 (model만 인식되고 view는 x)
- created: 뷰인스턴스 생성되고 데이터들 설정 완료되고 호출. dom은 요소 접근 안됨
- beforeMount: 마운트가 시작되기 전에 호출 (el이 인식됨 view 인식 o)
- mounted: 지정된 element가 뷰인스턴스 데이터가 마운트 된 후에 호출. 여기서 부터 template 속성에 정의한 화면 요소에 접근할 수있어 화면 요소 제어 로직 수행!
- beforeUpdate: 데이터가 변경되기 전에 뷰가 반영해주려고함
- updated: Vue에서 관리되는 데이터가 변경돼서 dom이 업데이트 된 상태. 데이터 변경 후 화면 요소 제어와 관련 로직 추가
- beforeDestroy
- detroyed

# 4. 보간법, 원시 html

- {{ 속성명 }} ← 여기 이렇게
- html 쓰려면 `v-html` 사용

# 5. Vue 디렉티브

- v-text
- v-html: {{}} 안에서 html 쓰려면 해야함
- v-once: 한번만 호출. 안바뀜
- v-model: 양방향 바인딩 위해서 처리. 인풋에 데이터 바꾸면 바로 바뀌는거!
- v-bind: 엘리먼트 속성이랑 연결하는거!! 얘만 약어로 `:` 사용 가능
- v-show: 조건에 따라 엘리먼트를 화면에 렌더링 style의 display바꾸는거
- v-if: 얘가 더 좋음
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%202.png)
    
- v-else-if
- v-else
- v-for: 배열이나 객체 반복에 사용
    - `v-for=”요소변수이름 in 배열” v-for=”(요소변수이름, 인덱스) in 배열”`
- v-cloak
    - 뷰인스턴스가 준비될때까지 mustache 바인딩을 숨김!!
    - `[v-cloak] {display: none}` 같이 사용
- v-on
- template: 여러개 태그 묶어서 처리할때 template사용
    - ex. v-if, v-for, component 쓸때
- Vue method
    - 생성과 관련된 data및 메서드의 정의가 가능
    - method안에서 data를 “this.데이터이름”으로 접근가능!

# 6. Vue Instance 속성 (method, filter, computed, 등)

## 6-1. method 속성

- 생성과 관련된 data및 메서드의 정의가 가능
- method안에서 data를 “this.데이터이름”으로 접근가능!

## 6-2. filter 속성

```markdown
<!-- 파이프 연산으로 필터를 연결해놓음! -->
  <h3>{{ msg | count1 }}</h3>
  <h3>{{ msg | count2('문자를 넣어보세요') }}</h3>
```

- 화면에 표시되는 텍스트 형식을 쉽게 변환해주는 기능!
- filter를 이용해서 표현식에 새로운 결과 형식을 적용
- 중괄호 보간법 `{{}}` 또는 `v-bind` 속성에서 사용가능함

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%203.png)

- 전역 필터
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%204.png)
    
- 지역 필터
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%205.png)
    
- 천단위마다 콤마 찍기, 전화번호에 대시넣기 등

## 6-3. computed 속성

- 특징 데이터의 변경 사항을 실시간으로 처리
- 캐싱을 이용해서 데이터의 변경이 없을경우에 캐싱된거 보여줌
- setter와, getter 직접 지정 가능
- 작성은 method형태로 작성하지만 vue에서 proxy처리해서 property처럼 사용한다.
- method는 똑같은 거 실행하면 계속 찍힘!! 실행하는만큼
- computed속성은 실행된 뷰 인스턴스 내에서 실행된 적이 있으면 다시 실행 안함.

```jsx
let vm = new Vue({
        data: {
          a: 1,
        },
        computed: {
          // get만 가능합니다.
          aDouble() {
            return this.a * 2;
          },
          // get과 set 입니다.
          aPlus: {
            get() {
              console.log('get');
              return this.a + 1;
            },
            set(v) {
              console.log('set');
              this.a = v - 1;
            },
          },
        },
      });
```

## 6-4. watch 속성

- vue Instance의 특정 property가 변경될 때 실행할 `콜백 함수 설정`

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%206.png)

```jsx
var vm = new Vue({
      el: '#app',
      data: {
        a: 1, //이걸 바꾸는게 아니라 이것때문에 다른게 바뀌는 거임!
      },
      watch: {
        a: function (val, oldVal) { //a가 아니라 현재값, 예전값을 가지고 하는게 watch!
          console.log('new: %s, old: %s', val, oldVal);
        },
      },
    });
    console.log(vm.a);
    vm.a = 2; // => new: 2, old: 1
    console.log(vm.a);
```

- `보면 a가 바뀌면 watch가 보고있다가 어?! 바꼇네 하고 바꿈 문법 잘봐`

### 6-5.watch랑 computed랑 차이!! 캐싱이랑|변경된거 보고 바꾸는거!!

- computed는 종속된 데이터가 변경되었을 경우 그 데이터를 다시 계산해서 캐싱함.
- watch의 경우 data가 변경되었을 경우 다른 data를 변경함

# 7. Vue Event

- 돔 이벤트를 청취하기 위해 `v-on` 디렉티브를 사용함
- 인라인 이벤트 핸들링
- 메서드를 이용한 이벤트 핸들링

## 7-1. v-on

- v-on 디렉티브 사용해서 돔이벤트를 듣고 트리거 될때 js 실행가능 `v-on:click`

```
<button v-on:click="counter += 1">클릭</button>
<p>위 버튼을 클릭한 횟수는 {{counter}} 번 입니다.</p>
```

- method event hander
    - 이벤트 발생시에 처리 로직을 v-on에 넣기 힘들어서 v-on에서는 이벤트 발생시 처리해야하는 method의 이름을 받아서 처리한다.
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%207.png)
    
    - 보면은 `v-on:click="greet"` 되어있고, 밑에 메서드에서 이름을 받아 처리함!! `greet: function (event) { }`
- inline method handler
    - 메소드 이름을 직접 바인딩 하는 대신, 인라인 js 구문에 메서드 사용도 가능
    - 원본 돔이벤트에 액세스해야하는 경우 `$event` 변수 사용해서 메서드에 전달 가능!!
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%208.png)
    
    ```jsx
    <body>
      <div id="app">
        <form action="http://www.naver.com">
          <button v-on:click="greet1('SSAFY')">Greet</button>
          <button v-on:click="greet2($event, 'Ssafy')">Greet</button>
        </form>
      </div>
      <script>
        new Vue({
          el: '#app',
          methods: {
            greet1: function (msg) {
              alert('Hello ' + msg + '!');
              console.dir(event.target);
            },
            greet2: function (e, msg) {
              //만약 이벤트가 있으면, 다음에 발생하는 이벤트를 무시해라
              if (e) e.preventDefault();
              alert('Hello ' + msg + '!');
              console.dir(e.target);
            },
          },
        });
      </script>
    </body>
    ```
    
- 이벤트 수식어
    - `event.preventDefault()`와 같이 method내에서 작업을 할수도잇는데, method는 dom의 이벤트를 처리하는 것보다 데이터 처리를 위한 로직만 작업하는 게좋음 !! 분리 !!
    - 이 문제를 위해 `v-on` 이벤트에 이벤트 수식어를 제공함
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%209.png)
    
    - `v-on:click.stop` : 클릭 이벤트 전파가 중단됨 . a태그
    - `v-on:submit.prevent` : 제출 이벤트가 페이지를 다시 로드안함. form태그
    - `v-on:click.stop.prevent`: 수식어는 체이닝 가능함. a 태그
    - `v-on:submit.prevent` : 단순히 수식어만 사용할 수 있음. form태그

- 키 수식어
    - 뷰는 키 이벤트를 수신할 때 v-on에 대한 키 수식어를 추가할 수 있음!!
        
        ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2010.png)
        
- `ref, $refs`
    - 뷰에서는 $refs 속성을 이용해서 dom에 접근 가능 !
    - 단, 뷰ㅜ의 가장 중요한 목적 중 하나는 개발자가 dom을 다루지 않게 하는것이므로, 되도록 ref사용안됨 !!
        
        ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2011.png)
        
        - 여기 보면 ref에 아이디명 주고 메서드안에서 건들음

# 8. CSS class binding

- element의 class와 style을 변경함
- `v-bind:class` 는 조건에 따라서 class를 적용할 수 있음
    
    ```html
    <body>
      <!-- 이 div는 가장 바깥에 있는거 (root) -->
      <div id="app">
        <!-- active란걸 false 사용안할거야. true면 사용할거야. 이런식으로 동적으로 사용 가능-->
        <div v-bind:class="{ active: isActive }">VueCSS적용</div>
        <button v-on:click="toggle">VueCSS</button>
      </div>
      <script type="text/javascript">
        new Vue({
          el: '#app',
          data: {
            isActive: false,
          },
          methods: {
            toggle: function () {
              this.isActive = !this.isActive;
            },
          },
        });
      </script>
    	</body>
    ```
    
    - 보면 `v-bind에 class= “{active : isActive}”` 보면 isActive가 false면 적용안하고 true면 하고 이런식

# 9. form input binding

- `v-model` 디렉티브를 사용해서 폼 Input, textarea element에 양방향 데이터 바인딩을 생성 가능
    - `텍스트와 텍스트에리아` 태그는 `value속성`과 `input이벤트`를 사용함!!!
    - `체크박스들이랑 라디오버튼들`은 `checked속성`이랑 `change 이벤트`를 사용
    - `select 태그`는 `value를 prop`으로, `change를 이벤트`로!!!

- v-model 사용할 때 .lazy 수식어 넣으면 change 이벤트 이후에 동기화 할 수있음

## 9-1. text, textarea

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2012.png)

## 9-2. checkbox

- 하나의 체크박스는 단일 boolean값을 갖는다.

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2013.png)

- 여러개의 체크박스는 같은 배열을 바인딩 할 수있음
    - 배열의 값과 checkbox의 value 속성이 같을 경우 처리된다..!!!
        
        ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2014.png)
        

## 9-3. radio

- radio의 경우 선택된 항목의 value 속성을 관리한다.

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2015.png)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2016.png)

## 9-4. select

- select box 일 경우 선택된 항목의 value 속성을 관리
- `v-model` 표현식의 초기값이 어떤 옵션에도 없으면 `<select>` element는 선택없음 상태로 렌더링!!!

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2017.png)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2018.png)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2019.png)

- v-for를 이용한 option 렌더링
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2020.png)
    

## 9-5. from- 수식어 (Modifiers)

### `[v-model.XXX](http://v-model.XXX)` 붙이면 된다!!!

- `.lazy` : change 이벤트 이후에 동기화!!!!
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2021.png)
    
- `.number` : 사용자 입력이 자동으로 숫자로 형변환됨!!!
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2022.png)
    
- `.trim` : input을 자동으로 trim하길 원하면 trim 수정자 추가!
    
    ![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2023.png)
    

# 10. Component

- vue의 가장 강력한 기능 중 하나!!
- html element를 확장해서 재사용 가능한 코드를 캡슐화함!
- vue component는 vue instance이기도 해서 모든 옵션 객체사용함
- life cycle hook 사용 가능
- 전역 컴포넌트, 지역 컴포넌트 사용!!

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2024.png)

## 10-1. 전역 컴포넌트

- 등록: `Vue.component(tagName, options)`
- 권장하는 컴포넌트이름: 케밥!!!

```jsx
<body>
  <div id="app1">
    <!-- 케밥으로 해야 나온다. -->
    <my-global></my-global>
    <my-global></my-global>
  </div>
  <div id="app2">
    <my-global></my-global>
    <my-global></my-global>
  </div>
  <script>
    //new vue new vue 보다 위에 잇음 전역 컴포넌트임. 컴포넌트이름은 파스칼 혹은 케밥case
    Vue.component("my-global", {
      //화면에 뭐를 출력할지를 설정. html을 묶어서 표현할 수 있는 템플릿 사용
      //template 여기는 하나의 루트만 잇어야함
      template: "<div><h2>전역 컴포넌트입니다.</h2><h3>안녕하세요</h3></div>", //여기에 끼어넣을지 설정을 해야돼요 ~ 디브안에
    });
    // 전역 컴포넌트 설정
    new Vue({
      el: "#app1",
    });
    new Vue({
      el: "#app2",
    });
  </script>
</body>
```

- new vue보다 위에 있으면 전역 컴포넌트임!!!
- 무족권 케밥으로!!!! `Vue.component("my-global", {   })`

## 10-2. 지역 컴포넌트

- 등록: 컴포넌트를 `components` 인스턴스 옵션으로 등록함으로써 다른 인스턴스/컴포넌트의 범위에서만 사용할 수 있는 컴포넌트를 만들 수 있따.

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2025.png)

```jsx
<body>
  <div id="app1">
    <my-local></my-local>
    <my-local></my-local>
  </div>
  <div id="app2">
    <!-- 여기선 my-local못쓴다 app1꺼니까 -->
    <my-local></my-local>
    <my-local></my-local>
  </div>
  <script>
    new Vue({
      el: "#app1", //my-local은 app1에서만 쓸 수 있찌
      // vue 객체 내에 있는 지역 컴포넌트 설정
      components: {
        //이름이 my-local이 될거다
        "my-local": {
          //이렇게 안에 템플릿쓰는게 좋을까? 아님 위에 템플릿을 따로 빼는게 좋을까? (ex.test03)
          //위에 빼는게 편하고 좋다
          template: "<h2>지역 컴포넌트입니다.</h2>",
        }
      },
    });
    new Vue({
      el: "#app2",
    });
  </script>
</body>
```

- 자 보면, 뷰 인스턴스 안에 들어가는게 components야!!! 지역이 s
- 뷰인스턴스 안에 들어가면 my-local이 컴포넌츠인데, 지금 뷰인스턴스가 app1에서만 쓸 수있게 됐으니까, 위에 div id=”app2” 에선 못 씀!!!!

## 10-3. Component Template

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2026.png)

```jsx
<body>
  <div id="app">
    <my-comp></my-comp>
  </div>
  <!-- template 설정 -->
  <!-- template 밖에 빼는게 더 편하다! -->
  <template>
    <div>
      <h2>{{ msg }}</h2>
    </div>
  </template>
  <script>
    Vue.component("my-comp", {
      template: "#mycomp", //얘는 아이디니까 안중요해 위 이름이 중요한거지
      data() { //이 데이터라는 옵션은 함수형태가 되어야함 그냥 data {} 안됨!!!
        return {
          msg: "hello component",
        };
      },
    });

    new Vue({
      el: "#app",
    });
  </script>
</body>
```

- 자 지금 보면 전역 컴포넌트 안에 템플릿으로 #mycomp 라고 이름을 붙였지???

## 10-4. Component Data 공유 문제

```jsx
<body>
  <h2>컴포넌트 데이터 공유 문제</h2>
  <div id="app">
    <count-view></count-view> //객체가 전달됨 총 세번! 근데 ref가 전달됨. 같은 ref가 전달되니까 세개가 다 똑같지
    <count-view></count-view> //그래서 test05번처럼 해야 따로따로 적용됨
    <count-view></count-view>
  </div>
  <template id="countview"> //이 템플릿은 count-view에 연결이 됨
    <div>
      <span>{{ count }}</span>
      <button @click="count++">클릭</button>
    </div>
  </template>
  <script>
    let num = { //num은 객체
      count: 0,
    };
    Vue.component("count-view", {
      data() {
        return num;
      },
      template: "#countview", //이걸 위에 템블릿 countview에 적용
    });
    new Vue({
      el: "#app",
    });
  </script>
</body>
```

이렇게 하면 `ref가 전달됨!!!` 그래서 count가 ++ 되지 않아… 이문제를 어떻게 해야할까??? 아래 

```jsx
<body>
  <h2>컴포넌트 데이터 공유 문제 해결</h2>
  <div id="app"> //얘는 지역화가 되어있음
    <count-view></count-view>
    <count-view></count-view>
    <count-view></count-view>
  </div>
  <template id="countview">
    <div>
      <span>{{ count }}</span>
      <button @click="count++">클릭</button>
    </div>
  </template>
  <!-- 여기까진 똑같음 -->
  <script>
    //but 카운트라는 변수가 아깐 바깥에객체로 만들엇지만 지금은 컴포넌트 안에있음
    Vue.component("count-view", {
      template: "#countview",
      data() {
        return { //안에 있으니까 부를때마다 새로 만들어지겟지 ?
          count: 0,
        };
      },
    });
    //정리: 한번에 하고싶다. 그러면 객체를 밖에 만들고, 아니면 안에 만들고
    //정리: 객체는 레퍼런스! 
    new Vue({
      el: "#app",
    });
  </script>
</body>
```

    //정리: 한번에 하고싶다. 그러면 객체를 밖에 만들고, 아니면 안에 만들고
    //정리: 객체는 레퍼런스! 

개중요!!! 객체는 레퍼런스니까 객체를 밖에 만들면 한번만 되고, 안에 만들면 각각되는거임!! 지역화가 중요

위에 공유되는 문제는 

```jsx
let num = { //num은 객체
      count: 0,
};
```

이걸 밖에 만들었잔ㄴㅎ아. 아래처럼 컴포넌트 안에 만들면 각각 호출돼서 ref가 공유되는 문제는 없다.

# 11. Component간 통신

- 상위 - 하위  컴포넌트간 data 전달 방법
- 부모에서 자식: props라는 특별한 속성을 전달 (Pass Props)
- 자식에서 부모: event로만 전달 가능 (Emit Event)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2027.png)

## 11-1. 상위에서 하위 컴포넌트로 data 전달

- 하위 컴포넌트는 상위 컴포넌트의 값을 직접 참조 불가능
- data와 마찬가지로 props 속성의 값을 template에서 사용이 가능

### props

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2028.png)

- child라는 컴포넌트를 정의해서 안에 props 만들고, 보내면된다.

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2029.png)

- 하위 컴포넌트에 props 속성에: [’propsdata’] 라고 잇잖아?
- 이걸 위에 child-component propsdata=”안녕하세요” 라고 하위 애한테 전해줬음
- 그리고 템플릿에 프롭스 데이터 넣어서 줌 ..!!!! 그래서 하위 컴포넌트에 전달된거임 여기서 div id=”app” 이 부모임!!!

### 렌더링 과정

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2030.png)

### 동적 props

- v-bind를 사용해서 부모의 데이터에 props를 동적으로 바인딩할 수 있음
- 데이터가 상위에서 업데이트 될 때마다 하위 데이터로 전달됨

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2031.png)

예시 

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2032.png)

이건 위에ㄱ 예시를 v-for 사용한거 

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2033.png)

### 객체의 속성(properties) 전달 props

- 오브젝트의 모든 속성을 전달할 경우, v-bind:prop-name 대신에 v-bind만 작성해서 모든 속성을 prop으로 전달 할 수있음

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2034.png)

위코드는 아래처럼 동작!!!!

## 사용자 정의 이벤트 ($emit)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2035.png)

** 중요 ** v-on 이벤트 리스너는 항상 자동으로 소문자 변환됨

그래서 이벤트 이름에는 케밥 권장~

예시

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2036.png)

```jsx
<body>
  <h2>사용자 정의 이벤트</h2>
  <div id="app">
    <!-- 클릭 전에 doAction 호출 -->
    <button v-on:click="doAction">메세지전송</button>
    <h2>{{message}}</h2>
  </div>
  <script>
    new Vue({
      el: "#app",
      data: {
        message: "",
      },
      methods: {
        doAction() {
          this.$emit("sendMsg", "안녕하세요 여러분"); //$emit event를 발생시켜라!! (커스텀 이벤트) 안녕하세요 여러분을 보내라
        },
      },
      created() { //이 콜백함수에 안녕하세요 여러분이 들어가
        this.$on("sendMsg", (msg) => { //귀 기울여 sendMsg 감시해 !!
          alert(msg);
          this.message = msg;
        });
      },
    });
    //emit 이벤트발생
    //그걸 낚아채는게 on
  </script>
</body>
```

- 이벤트 발생은 $emit
- 이벤트 수신은 $on 낚아챔
- created() 에서 아이디준거를 귀를 기울이다가 잡아챔!!!

## 11-2. 하위에서 상위 컴포넌트로 event 전달 (자식 → 부모)

- 하위 컴포넌트에서 상위 컴포넌트가 지정한 이벤트를 발생 에밋
- 상위 컴포넌트는 하위 컴포넌트가 발생한 이벤트를 수신해서 data처리

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2037.png)

이건 비권장 그래서 아래처럼 쓰기도해~ 

## 11-3. 비 상하위간 통신

- 비어있는 vue instance 객체를 event bus로 사용한다.
- 복잡해질 경우 상태관리 라이브러리인 vuex 사용 권장

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2038.png)

# 12. Axios

- http 통신 : axios
- promise 기반의 http 통신 라이브러리이며 상대적으로 다른 Http 통신 라이브러리들에 비해 굳

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2039.png)

# 13. Vue Router

- 라우팅: 웹 페이지 간의 이동 방법
- 라우터는 컴포넌트랑 매핑
- url 에 따라 컴포넌트 연결하고 설정된 컴포넌트 보여줌

## 13-1. vue router 연결

- routes 옵션과 함께 router instance 생성

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2040.png)

- new VueRouter
- routes: [   { path: ‘/’, component: Main}   ]

## 13-2. vue-router 이동 및 렌더링

- 네비게이션을 위해 router-link 컴포넌트 사용함
- 속성은 to !! prop사용
- 기본적으로 router-link는 a태그로 렌더링

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2041.png)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2042.png)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2043.png)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2044.png)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2045.png)

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2046.png)

### 이름을 가지는 라우트

- 라우트는 연결하거나 탐색을 수행할 때 이름이 있는 라우트를 사용해
- router instance를 생성하는 동안 routes 옵션에지정해줌

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2047.png)

### 프로그래밍 방식 라우터

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2048.png)

- 쿼리랑, 파람이랑 잘 알아둬 …

### 라우트 리다이렉트

![Untitled](Vue%20%E1%84%80%E1%85%AA%E1%84%91%E1%85%A7%E1%86%BC%20%E1%84%83%E1%85%A2%E1%84%87%E1%85%B5%2071695633fd2e40e9a3768233e74b2765/Untitled%2049.png)