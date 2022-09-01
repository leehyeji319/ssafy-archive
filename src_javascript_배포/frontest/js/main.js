// window.onload = function () {
  
// };

//여기에 추가
let question = localStorage.getItem("question"); //question이라고 되어있는 투표의 질문을 얻어와라
//이렇게 두기 얻어놓고
let contentLeftPollDiv = document.querySelector(".content-left-poll");
let contentLeftPollBtnDiv = document.querySelector(".content-left-poll-btn");


if (question) {
    // console.log("진행중인 투표있음.");
    let answers = localStorage.getItem("answers"); //저장한놈을 얻어와라
    //하지만 내가 원하는건 문자열이 아니라 배열이니까 역직렬화
    let answerArr = JSON.parse(answers);
    console.log(answerArr);
    //이제 투표만들기 없애고 투표창이 뜨게 해야함
    //여기에 poll.html이 딱 들어가야함! class="poll" 안에있는 애들만 복사
    //백틱을 이용하여.. 백틱은 엔터까지 인식함 
    let poll = `
        <div class="poll-title">[당신의 선택]</div>
        <div class="poll-question">${question}</div>
        <div class="poll-answer">
            <ul>
        `; //반복문 들어간다
    answerArr.forEach(function (answer) {
        // poll이라는 문자열에 계속 더해라
        poll += `<li><input type="radio" name="poll-answer" id="" /> ${answer}</li>`;
    });

    //다시 백틱시작 ㅋㅋ 
    poll += `
        </ul>
        </div>
        <div class="poll-btn">
            <button id="btn-poll" class="button btn-primary">투표하기</button>
            <button class="button">이전결과보기</button>
        </div>
        <div class="poll-date">투표기간 : 2022.09.01 ~ 2022.09.30</div>
    `;

    contentLeftPollDiv.innerHTML = poll;
    contentLeftPollDiv.style.display = "";
    contentLeftPollBtnDiv.style.display = "none";
} else {
    // console.log("진행중인 투표없음.");
    //얘는 반대가 되면 되겠죠? 버튼이 보이게끔
    contentLeftPollDiv.style.display = "none";
    contentLeftPollBtnDiv.style.display = "";
}

document.querySelector("#btn-makepoll").addEventListener("click", function () {
    window.open('./makepoll.html', 'mkpoll', 'width=420, height=300');
})