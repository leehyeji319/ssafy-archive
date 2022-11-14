import Vue from 'vue'
import Vuex from 'vuex'
import Constant from '@/common/Constant.js';
import restApi from "@/util/http-common.js";
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    depts: []
  },
  mutations: { //dao느낌
    //가져온걸 state에 저장한거니까 SET_DEPTS
    [Constant.SET_DEPTS](state, payload) {
      state.depts = payload; //state의 depts에 payload 저장
    }
  },
  actions: { //service느낌
    //컨사이스 메서드 느낌으로 사용하고 싶은거잖아
    [Constant.GET_DEPTS](context) { //계산형 속성 중괄호 [ ]
      restApi.get("/api/depts").then(({ data }) => {
        this.depts = data;
          //commit을 해서 mutation을 일으켜야함
        context.commit(Constant.SET_DEPTS, data);
        //commit에 뮤테이션에 있는 메서드 이름을 주면 되지?
      });
    }
  },
})
