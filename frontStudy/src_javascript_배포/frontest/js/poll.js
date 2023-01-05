window.onload = function () {
    document.querySelector("#btn-add").addEventListener("click", function () {
        let listDiv = document.querySelector("#poll-answer-list")
    //   div, input, 삭제 버튼 만들어야댐
        //div먼저 만들기
        let divEl = document.createElement("div");
        //div에 class 적용하기 
        divEl.setAttribute("class", "poll-answer-item");
        
        //input만들기 
        let inputEl = document.createElement("input");
        inputEl.setAttribute("type", "text");
        inputEl.setAttribute("name", "answer");

        //button만들기
        let buttonEl = document.createElement("button");
        //button누를때마다 삭제할거란말임 그래서 타입을 버튼으로 -> 아무일도 안일어남
        buttonEl.setAttribute("type", "button");
        buttonEl.setAttribute("class", "button"); //버튼이라는 클래스를 적용할거야
        buttonEl.appendChild(document.createTextNode("삭제")); //삭제라는 글자만 추가하는게아니라 textNode로 만들고 button의 child로 추가해줌
        
        //삭제를 하라고 클릭 이벤트를 또 붙여주면 되지
        buttonEl.addEventListener("click", function () {
            //삭제라는걸 누르면 부모(div)를 지우면 되잖아
            //부모를 호출하기 -> 여기서 this. 화살표가 아니니까
            let parentEl = this.parentElement; //버튼을 포함하고있는것의 부모 element얻어오기
            listDiv.removeChild(parentEl); //listDiv에서 parentEl을 지워버려라
        })

        divEl.appendChild(inputEl);
        divEl.appendChild(buttonEl);

        listDiv.appendChild(divEl);
    });

    document.querySelector("#btn-make").addEventListener("click", function () {
        //질문 id 가 question임
        //querySelection("#question")하면 <input>까지만 얻어옴 뒤에 value 잇어야함
        let question = document.querySelector("#question").value;
        if (!question) { //비어있다면
            alert("질문을 반드시 입력하세요.");
            return;
        }

        //이거 forEach로도 가능
        //투표목록
        //input타입은 text고 answer라는 이름을 가지고 있는... answer라는 태그가 되지 이렇게 하면 <answer>라는 태그가 되어버림
        // let answers = document.querySelectorAll("answer") 
        let answers = document.querySelectorAll("[name=answer]"); //이렇게해야 name이 answer인 애를 가져옴
        console.log(answers);
        //of라는것도 있다
        for (let answer of answers) {
            // console.log(answer.value); //우리가 알고있는 것처럼 for answer : answers 같은거임 자바처럼! answer.value
            if (!answer.value) { //하나라도 입력안한애가 있다면
                alert("답변을 입력하세요.");
                return;
            }
        }
        
        let answerArr = [];
        for (let answer of answers) {
            //push라는 메서드로 answer를 담을 수 있다.
            answerArr.push(answer.value); //["서울", "대전" .. "부울경"]
        }

        //question하고 answerArr을 어디엔가 저장을 해놔야 꺼내서 쓸 수 있겠죠?
        //localStorage에 저장해보자!
        localStorage.setItem("question", question);
        // localStorage.setItem("answers", answers); //answre는 문자열이 아니라 배열이지? 그래서 이렇게 하면 안됨
        localStorage.setItem("answers", JSON.stringify(answerArr)); //그래서 json 직렬화를 사용해서 문자열 형태로 변환가능하다 -> 이게 직렬화
        // ["서울", "대전" .. "부울경"] 이게 "answers:["서울", "대전" .. "부울경"]" 이렇게 되는것. 나중에 사용할 땐 역직렬화하면 된다.
        
        if (confirm("투표생성하시겠습니까?")) {//예 true, 아니오 false
            opener.location.reload();
            self.close(); //지금 열려있는건 닫아버리면 된다
        }
    });
};
