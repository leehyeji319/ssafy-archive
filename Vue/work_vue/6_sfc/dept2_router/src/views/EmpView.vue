<template>
  <div class="container" id="empView">
    <h1>사원관리</h1>
    <emp-list></emp-list>
    <router-view @change-data="refreshData"></router-view>
  </div>
</template>

<script>
import EmpList from "@/components/EmpList.vue";
export default {
  data() {
    return {
      mode: "register",
      detpno: 0,
      refresh: new Date().getTime(),
    };
  },
  components: {
    EmpList,
  },
  method: {
    refreshData() {
      this.refresh = new Date().getTime();
      console.log(`refresh reset`);
    },
  },
};
</script>

<style>

</style>