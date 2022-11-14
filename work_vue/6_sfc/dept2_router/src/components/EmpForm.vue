<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-danger text-light text-center">사원 등록</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="empno">사원 번호</label></th>
            <td>
              <input type="text" name="empno" v-model.lazy="emp.empno" />
            </td>
          </tr>
          <tr>
            <th><label for="ename">사원 이름</label></th>
            <td>
              <input type="text" name="ename" id="ename" v-model.lazy="emp.ename" />
            </td>
          </tr>
          <tr>
            <th><label for="job">직업</label></th>
            <td>
              <input type="text" name="job" id="job" v-model.lazy="emp.job" />
            </td>
          </tr>
          <tr>
            <th><label for="deptno">부서 번호</label></th>
            <td>
              <input type="text" name="deptno" id="deptno" v-model.lazy="emp.deptno" />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="등록" @click="registerEmp" class="btn btn-warning m-1" />
              <input type="reset" value="취소" class="btn btn-info m-1" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<script>
import restApi from "@/util/http-common.js";
export default {
  data() {
    return {
      emp: {},
    }
  },

  methods: {
    registerEmp() {
      restApi.post(`/api/emps`, this.emp).then(() => {
        console.log(`registerEmp success`);
        // this.$emit("changed-data");
        this.clear();
        this.$router.push("/emp");
      });
    },
    clear() {
      this.emp = {};
    },
  },
  created() {
    console.log("EmpForm created...");
  }
}
</script>

<style>

</style>