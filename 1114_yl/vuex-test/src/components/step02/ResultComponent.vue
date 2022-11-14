<template>
  <div>
    <h2>{{ total }}</h2>
    <h2>{{ countMsg }}</h2>
  </div>
</template>

<script>
export default {
  computed: {
    total() {
      return this.$store.state.count;
    },
    countMsg() {
      return this.$store.getters.countMsg; //getters 에서 countMsg를 가져오래 
      //getters는 computed처럼 사용이 가능하다. 그래서 함수형태가 아니고 값처럼 활용 가능! 
    },
  },
};
</script>

<style></style>
