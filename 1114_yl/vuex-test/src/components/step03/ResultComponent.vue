<template>
  <div>
    <h2>{{ total }}</h2>
    <h2>{{ countMsg }}</h2>
    <!-- mapGetter() 
    <h2>{{ $store.getters.msg1 }}</h2>
    <h2>{{ $store.getters.msg2 }}</h2>
    <h2>{{ $store.getters.msg3 }}</h2>
    -->
    <!--아래꺼처럼 쓰는게 더 편하다-->
    <h2>{{ msg1 }}</h2>
    <h2>{{ msg2 }}</h2>
    <h2>{{ msg3 }}</h2>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    // ...mapGetters({ //전개 연산자를 사용해서 mapGetters라고 받는다.
    //   //countMsg이름으로 메세지 123 받음 -> 바로 쓸 수 있음!
    //   countMsg: "countMsg",
    //   msg1: "msg1",
    //   msg2: "msg2",
    //   msg3: "msg3",
    // }),
    //property shorthand
    ...mapGetters(["countMsg", "msg1", "msg2", "msg3"]),
    total() {
      return this.$store.state.count;
    },
    // countMsg() {
    //   return this.$store.getters.countMsg;
    // },
  },
};
</script>

<style></style>
