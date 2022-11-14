<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-info text-light text-center">사원 조회</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="empno">사원 번호</label></th>
            <td>
              <input
                type="text"
                name="empno"
                id="empno"
                v-model.lazy="emp.empno"
                :readonly="emp != null && emp.empno"
              />
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
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input type="text" name="deptno" id="deptno" v-model.lazy="emp.deptno" />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="수정" @click="modifyEmp" class="btn btn-warning m-1" />
              <input type="button" value="삭제" @click="removeEmp" class="btn btn-dark m-1" />
              <input type="reset" value="취소" class="btn btn-info m-1" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<script>
import restApi from "@/util/http-common";
export default {
  props: ["empno"],
  data() {
    return {
      emp: {},
    }
  },
  methods: {
    getEmp() {
      if (this.empno == 0) return;
      restApi.get(`/api/emps/${this.empno}`)
        .then(({ data }) => (this.emp = data));
    },
    modifyEmp() {
      restApi.put(`/api/emps/${this.emp.empno}`, this.emp)
        .then(() => {
          console.log(`modifyEmp success`);
          this.$router.push("/emp");
        });
    },
    removeEmp() {
      restApi.delete(`/api/emps/${this.emp.empno}`)
        .then(() => {
          console.log('removeEmp success');
          this.clear();
          this.$router.push("/emp");
        });
    },
    clear() {
      this.emp = {};
    }
  },
  watch: {
    empno() {
      this.getEmp();
    },
  },
  created() {
    this.getEmp();
    console.log("EmpDetail created...");
  }
};
</script>

<style>

</style>