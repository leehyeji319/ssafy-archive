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
      // this.$emit("addtotcount");
      //누르면 저장소에 있는걸 바꿔라
      this.$store.state.count++; //뷰엑스에 데이터에 접근할때는 $store 사용한다. 그러면 store의 index.js 까지들어감
    },
  },
};
</script>

<style></style>
