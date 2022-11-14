<template>
  <button @click="addCount">{{ title }} - {{ count }}</button>
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
      //this.$store 하면 index.js 까지 자동으로 찾아서 들어간다.
      this.$store.state.count++; //얘도 state를 직접 바꾸고있는 예제임 (1번처럼)
    },
  },
};
</script>

<style></style>
