<template>
  <div class="container">
    <h1>Department Management</h1>
    <dept-list @select-dept="receiveDept"></dept-list>
    <dept-detail :deptno="this.deptno"></dept-detail>
  </div>
</template>

<script>
import DeptList from '@/components/DeptList.vue';
import DeptDetail from '@/components/DeptDetail.vue';
export default {
  data() {
    return {
      deptno: 0
    }
  },
  components: {
    DeptList,
    DeptDetail
  },
  methods: {
    receiveDept(deptno) {
      console.log(this.deptno, deptno);
      this.deptno = deptno;
    }
  },
}
</script>

<style scoped>
</style>