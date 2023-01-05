<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-danger text-light text-center">부서 등록</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input type="text" name="deptno" v-model.lazy="dept.deptno" />
            </td>
          </tr>
          <tr>
            <th><label for="dname">부서이름</label></th>
            <td>
              <input type="text" name="dname" id="dname" v-model.lazy="dept.dname" />
            </td>
          </tr>
          <tr>
            <th><label for="loc">지역</label></th>
            <td>
              <input type="text" name="loc" id="loc" v-model.lazy="dept.loc" />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="등록" @click="registerDept" class="btn btn-warning m-1" />
              <input type="reset" value="취소" class="btn btn-info m-1" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
</template>

<script>
import Constant from "@/common/Constant";
export default {
  data() {
    return {
      dept: {},
    };
  },
  methods: {
    registerDept() {

      this.$store.dispatch(Constant.REGISTER_DEPT, this.dept)
        .then(() => { //dispatch가 promise를 준다.
          console.log(`registerDept success`);
          this.clear();
          this.$router.push("/dept");
        });

        //vuex를 쓰게되면서 refresh를 하지 않아도 괜찮게 됏다
        //why? 어차피 computed로 store에서 바뀌는 데이터를 받아올것이라서
      /*
      restApi.post(`/api/depts`, this.dept).then(() => {
        console.log(`registerDept success`);
        this.$emit("change-data");
        this.clear();
        this.$router.push("/dept");
       */
    },
    clear() {
      this.dept = {};
    },
  },
  created() {
    console.log("DeptForm created..");
  },
};
</script>

<style></style>
