<template>
  <h2>{{ total }}</h2>
</template>

<script>
export default {
  // props: ["total"],
  computed: {
    total() {
      return this.$store.state.count; //이 값이 바꼇을 때만 재계산해서 올라가겟지 ...
    },
  },
};
</script>

<style></style>
