<template>
  <div>
    <button @click="addCount">{{ title }} - {{ count }}</button>
    <button @click="addTenCount">{{ title }} - {{ count }}</button>
    <button @click="addObjCount">{{ title }} - {{ count }}</button>
    <button @click="asyncCount">Action {{ title }} - {{ count }}</button>
  </div>
</template>

<script>
//$안쓰려고 map으로 바로 한방에 다 얻어온거야,, 만약 state면 mapState,  등등 쓰면돼..
import { mapMutations, mapActions } from "vuex";
export default {
  name: "SubjectComponent",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  methods: { //얘는 숏핸드를 못쓰는 이유는? 이름이 다르니까 어쩔수없이 그런거지 
    //addMOne: "ADD_ONE" //이름이 달라서 숏핸드 안쓴거임!
    ...mapMutations({
      addMOne: "ADD_ONE", //소문자말고 대문자로!!
      addMTenCount: "ADD_TEN_COUNT",
      addMObjCount: "ADD_OBJ_COUNT",
    }),
    ...mapActions(["asyncAddOne"]),
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
      //원랜 this.$store.dispatch 였지 근데 바뀜 
      //왜? ...mapActions 써가지고 요 이름에 핻아하는것만 얻어오라고 햇으니까
      this.asyncAddOne();
    },
  },
};
</script>

<style></style>
