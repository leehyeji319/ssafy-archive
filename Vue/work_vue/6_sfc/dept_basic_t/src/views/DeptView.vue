<template>
  <div class="container">
    <h1>부서 관리</h1>
    <dept-list
      @select-dept="receiveDept"
      :refresh="refresh"
      @change-form="changeForm"
    ></dept-list>
    <dept-form
      v-show="mode == 'register'"
      @change-data="refreshData"
    ></dept-form>
    <dept-detail
      :deptno="deptno"
      @change-data="refreshData"
      v-show="mode == 'detail'"
    ></dept-detail>
  </div>
</template>

<script>
import DeptList from "@/components/DeptList.vue";
import DeptDetail from "@/components/DeptDetail.vue";
import DeptForm from "@/components/DeptForm.vue";

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
    DeptDetail,
    DeptForm,
  },
  methods: {
    receiveDept(deptno) {
      this.deptno = deptno;
      this.mode = "detail";
    },
    refreshData(payload) {
      this.refresh = new Date().getTime();
      if (payload == null) {
        this.mode = "";
      } else {
        this.mode = payload;
      }
      console.log(`refresh reset`);
    },
    changeForm(payload) {
      this.mode = payload;
    },
  },
};
</script>

<style>
</style>