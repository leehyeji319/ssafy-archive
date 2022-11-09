<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">부서 목록</h2>
    </div>
    <div class="row">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>번호</th>
            <th>부서번호</th>
            <th>이름</th>
            <th>지역</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="depts.length == 0">
            <td colspan="3">등록된 부서정보가 없습니다.</td>
          </tr>
          <template v-else>
            <tr v-for="(dept, index) in depts" :key="dept.deptno" @click="pickDept(dept.deptno)">
              <td>{{ index + 1 }}</td>
              <td>{{ dept.deptno }}</td>
              <!-- <td><a :href="`./dept_detail.html?deptno=${dept.deptno}`">{{ dept.dname }}</a></td> -->
              <td>{{ dept.dname }}</td>
              <td>{{ dept.loc }}</td>
            </tr>
          </template>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  export default {
    data() {
      return {
        depts: []
      }
    },
    methods: {
      getUsers() {
        axios.get("http://localhost:8080/api/depts")
        .then(({ data }) => this.depts = data)
      },
      pickDept(deptno) {
        this.$emit("select-dept", deptno)
      }
    },
    created() {
      this.getUsers();
    },  
  }
</script>

<style scoped>

</style>