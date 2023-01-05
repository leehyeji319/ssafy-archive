import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

// step01;
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
// });

//step02
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed 하고 나서 리턴을 해주니까 컴퓨티드처럼 바로 호출해서 사용할 수 있는것이다
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

//step03
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//     //getters가 여러개 있을 때
//     msg1(state) {
//       return "msg1 : " + state.count;
//     },
//     msg2(state) {
//       return "msg2 : " + state.count;
//     },
//     msg3(state) {
//       return "msg3 : " + state.count;
//     },
//   },
// });

//step04
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   mutations: {
//     ADD_ONE(state) {
//       state.count += 1;
//     },
//     //첫번째인자: state, 두번째인자: payload 받아낸 데이터
//     ADD_COUNT(state, payload) { //mutations에서 commit을 호출하는데 (name, parameter)임
//       state.count += payload;
//     },
//     ADD_OBJ_COUNT(state, payload) { //얘는 payload가 object
//       state.count += payload.num;
//     },
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

//step05
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//   mutations: {
//     ADD_ONE(state) {
//       state.count += 1;
//     },
//     ADD_TEN_COUNT(state, payload) {
//       state.count += payload;
//     },
//     ADD_OBJ_COUNT(state, payload) {
//       state.count += payload.num;
//     },
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

//step06
// export default new Vuex.Store({
//   state: {
//     count: 0,
//   },
//    //dispatch! actions에 들어가서 asyncAddOne을 찾음
//   //asyncAddOne의 첫번째 인자값은 context라는 값을 가져간다.
//   //서블릿할때 servletContext는 프로젝트의 어디에든 접근가능했지?
//   //vue의 context는 커밋, 디스패치,게터스,스테이트.. 다 접근할 수 있음 다 들어있어!!
//   //여기서 state를 언제든지 접근할 수 있찌만 actions에선 state바꾸지 말아라.
//   actions: {
//     asyncAddOne({ commit }) {
//       setTimeout(() => {
//         commit("ADD_ONE");
//       }, 2000); //2초가 지나야지 처리하는 비동기.
//     },
//   },
//   mutations: {
//     ADD_ONE(state) {//2초가 지난다음에 얘를 호출함
//       state.count += 1;
//     },
//     ADD_TEN_COUNT(state, payload) {
//       state.count += payload;
//     },
//     ADD_OBJ_COUNT(state, payload) {
//       state.count += payload.num;
//     },
//   },
//   getters: {
//     // 복잡한 계산식을 처리 : computed
//     countMsg(state) {
//       // return state.count + '번 호출됨';
//       let msg = "10번보다 ";
//       if (state.count > 10) {
//         msg += "많이 ";
//       } else {
//         msg += "적게 ";
//       }
//       return msg + " 호출됨(" + state.count + ")";
//     },
//   },
// });

//step07
export default new Vuex.Store({
  state: {
    count: 0,
  },
  actions: {
    asyncAddOne(context) {
      setTimeout(() => {
        context.commit("addOne");
      }, 2000);
    },
  },
  mutations: {
    ADD_ONE(state) {
      state.count += 1;
    },
    ADD_TEN_COUNT(state, payload) {
      state.count += payload;
    },
    ADD_OBJ_COUNT(state, payload) {
      state.count += payload.num;
    },
  },
  getters: {
    // 복잡한 계산식을 처리 : computed
    countMsg(state) {
      // return state.count + '번 호출됨';
      let msg = "10번보다 ";
      if (state.count > 10) {
        msg += "많이 ";
      } else {
        msg += "적게 ";
      }
      return msg + " 호출됨(" + state.count + ")";
    },
  },
});
