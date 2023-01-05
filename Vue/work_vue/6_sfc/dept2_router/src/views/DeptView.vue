<template>
  <div class="container" id="deptView">
    <h1>부서 관리</h1>
    <dept-list :refresh="refresh" ></dept-list>
    <router-view @change-data="refreshData"></router-view>
    <!-- <dept-detail v-show="mode == 'detail'" :deptno="deptno" @change-data="refreshData"></dept-detail>
    <dept-form v-show="mode == 'register'" @change-data="refreshData"></dept-form> -->
  </div>
</template>

<script>
import DeptList from "@/components/DeptList.vue";

export default {
  data() {
    return {
      mode: "register",
      deptno: 0,
      refresh: new Date().getTime(),
    };
  },
  components: {
    DeptList,
    //라우터에서 이미 받아왔으니까 컴포넌트 임포트 없애도됨
  },
  methods: {
    refreshData() {
      this.refresh = new Date().getTime();
      console.log('refresh reset');
    },
  },
};
</script>

<style></style>
