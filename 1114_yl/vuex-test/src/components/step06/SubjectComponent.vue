<template>
  <div>
    <button @click="addCount">{{ title }} - {{ count }}</button>
    <button @click="addTenCount">{{ title }} - {{ count }}</button>
    <button @click="addObjCount">{{ title }} - {{ count }}</button>
    <button @click="asyncCount">Action {{ title }} - {{ count }}</button>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
export default {
  name: "SubjectComponent",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    ...mapMutations({
      addMOne: "ADD_ONE",
      addMTenCount: "ADD_TEN_COUNT",
      addMObjCount: "ADD_OBJ_COUNT",
    }),
    addCount: function () {
      this.count += 1;
      // this.$store.commit('addOne');
      this.addMOne();
    },
    addTenCount: function () {
      this.count += 10;
      // this.$store.commit('addCount', 10);
      this.addMTenCount(10);
    },
    addObjCount: function () {
      let num = Math.round(Math.random() * 100);
      this.count += num;
      // this.$store.commit('addObjCount', { num });
      this.addMObjCount({ num });
    },
    asyncCount() {
      //아~ 근데 또 $ 이거 쓰고있네,,, 내장객체 만지는거 안좋다니까!! 예제 7번가보자고
      this.$store.dispatch("asyncAddOne"); //dispatch! actions에 들어가서 asyncAddOne을 찾음
      //asyncAddOne의 첫번째 인자값은 context라는 값을 가져간다.
      //서블릿할때 servletContext는 프로젝트의 어디에든 접근가능했지?
      //vue의 context는 커밋, 디스패치,게터스,스테이트.. 다 접근할 수 있음 다 들어있어!!
      //여기서 state를 언제든지 접근할 수 있찌만 actions에선 state바꾸지 말아라.
    },
  },
};
</script>

<style></style>
