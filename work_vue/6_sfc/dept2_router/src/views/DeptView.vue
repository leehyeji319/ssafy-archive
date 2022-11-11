<template>
  <div class="container" id="deptView">
    <h1>부서 관리</h1>
    <dept-list :refresh="refresh" @select-dept="receiveDept" @change-form="changeForm"></dept-list>
    <dept-detail v-show="mode == 'detail'" :deptno="deptno" @change-data="refreshData"></dept-detail>
    <dept-form v-show="mode == 'register'" @change-data="refreshData"></dept-form>
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

<style></style>
