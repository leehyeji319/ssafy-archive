<template>
  <div>
    <button @click="addCount">{{ title }} - {{ count }}</button>
    <button @click="addTenCount">{{ title }} - {{ count }}</button>
    <button @click="addObjCount">{{ title }} - {{ count }}</button>
  </div>
</template>

<script>
import { mapMutations } from "vuex"; //얘네들의 이름을 한방에 얻어오자!!

export default {
  name: "SubjectComponent",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  //$가 붙은 애들은 내장객체임. step04처럼 직접적으로 내장객체 건드리는건 별로인거같아.. 그래서 바꾸자!
  methods: { //vuex에서 얻어와. 직접적으로 mapMutations도 property shorthand로 받아버리면 됨
    ...mapMutations({ //mapMutations 방법으로 호출!
      addMOne: "ADD_ONE", //이런 이름으로 뮤테이션을 쓸거야!
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
  },
};
</script>

<style></style>
