<template>
  <div>
    <button @click="addCount">{{ title }} - {{ count }}</button>
    <button @click="addTenCount">{{ title }} - {{ count }}</button>
    <button @click="addObjCount">{{ title }} - {{ count }}</button>
  </div>
</template>

<script>
export default {
  name: "SubjectComponent",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    addCount: function () {
      this.count += 1;
      this.$store.commit("ADD_ONE"); //소문자로하면 mutations의 add_one인지 actions의 add_one인지 알수 없음.
      //그래서 mutations은ㅇ 대문자. actions는 카멜케이스
      // this.$store.state.count++;
    },
    addTenCount: function () {
      this.count += 10;
      this.$store.commit("ADD_COUNT", 10);
    },
    addObjCount: function () {
      let num = Math.round(Math.random() * 100);
      console.log(num);
      this.count += num;
      this.$store.commit("ADD_OBJ_COUNT", { num });
    },
  },
};
</script>

<style></style>
