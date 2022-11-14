<template>
  <div>
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">부서 목록</h2>
      <!-- <div class="row mt-3">
        <form class="text-center" method="post">
          <input type="text" name="dname" placeholder="부서명을입력하세요" />
          <input type="text" name="loc" placeholder="지역을 입력하세요" />
          <input type="submit" value="검색" />
        </form>
      </div> -->
    </div>
    <div class="row">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>번호</th>
            <th>부서번호</th>
            <th>부서이름</th>
            <th>부서지역</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="deptList.length == 0">
            <td colspan="4">등록된 부서정보가 없습니다.</td>
          </tr>
          <template v-else>
            <tr v-for="(dept, index) in deptList" :key="dept.no" @click="pickDept(dept.deptno)">
              <td>{{ index + 1 }}</td>
              <td>{{ dept.deptno }}</td>
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
import axios from "axios"; //vimport, nodle_modules에 있는거 사용할땐 import
export default {
  props: {
    flag: {
      type: Boolean,
      default: false,
    },
  },
  data() {
    return {
      deptList: [],
    };
  },
  methods: {
    getDept() {
      axios.get("http://127.0.0.1:8080/api/depts").then(({ data }) => (this.deptList = data));
    },
    pickDept(deptno) {
      this.$emit("select-dept", deptno);
    },
  },
  watch: {
    flag() { 
      this.getDept();
    },
  },
  created() {
    this.getDept();
  },
};
</script>

<style scoped></style>