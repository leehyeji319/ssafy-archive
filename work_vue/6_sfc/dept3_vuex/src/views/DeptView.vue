<template>
  <div class="container" id="deptView">
    <h1>부서 관리</h1>
    <dept-list></dept-list>
    <router-view></router-view>
      </div>
</template>

<script>
import DeptList from "@/components/DeptList.vue";

export default {
  components: {
    DeptList,
    //라우터에서 이미 받아왔으니까 컴포넌트 임포트 없애도됨
  },

};
</script>

<style></style>
