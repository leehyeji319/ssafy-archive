import Vue from 'vue'
import Vuex from 'vuex'
import Constant from '@/common/Constant.js';
import restApi from "@/util/http-common.js";
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    depts: [],
    dept: {} //비어있는 state하나 추가해줌 
  },
  getters: {
    depts(state) {
      // return state.depts;
      return state.depts.filter(item => item.deptno>20);
    }
  },
  mutations: { //dao느낌
    //가져온걸 state에 저장한거니까 SET_DEPTS
    [Constant.SET_DEPTS](state, payload) {
      state.depts = payload; //state의 depts에 payload 저장
    },
    [Constant.SET_DEPT](state, payload) {
      state.dept = payload;
    }
  },
  //다 프로미스를 리턴하게 줘도 될듯~
  actions: { //service느낌
    //컨사이스 메서드 느낌으로 사용하고 싶은거잖아
    [Constant.GET_DEPTS](context) { //계산형 속성 중괄호 [ ]
      return restApi.get("/api/depts").then(({ data }) => {
        // this.depts = data;
        //commit을 해서 mutation을 일으켜야함
        context.commit(Constant.SET_DEPTS, data);
        //commit에 뮤테이션에 있는 메서드 이름을 주면 되지?
      });
    },
    [Constant.REGISTER_DEPT](context, payload) {
      return restApi.post(`/api/depts`, payload) //여기서 리턴붙이면? 우리가 직접 프로미스를 리턴하는거임
        .then(() => console.log(`store action ${Constant.REGISTER_DEPT}`));
    },
    [Constant.GET_DEPT](context, payload) {
      return restApi.get(`/api/depts/${payload}/emps`)
        .then(({ data }) => context.commit(Constant.SET_DEPT, data)); //이 데이터를 state에 넣어줘야함
    },
    [Constant.MODIFY_DEPT](context, dept) {
      return restApi.post(`/api/depts/${dept.deptno}`, dept)
        .then(() => console.log(`sotre action ${Constant.MODIFY_DEPT}`));
    },
  },
})
