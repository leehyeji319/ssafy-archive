<template>
  <div>
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">{{ deptno }}부서 조회 with emps</h2>
    </div>
    <form method="post" class="row">
      <table class="table">
        <tbody>
          <tr>
            <th><label for="deptno">부서번호</label></th>
            <td>
              <input
                type="text"
                name="deptno"
                id="deptno"
                v-model="deptDetail.deptno"
              />
            </td>
          </tr>
          <tr>
            <th><label for="dname">부서이름</label></th>
            <td><input type="text" name="dname" id="dname" v-model="deptDetail.dname" /></td>
          </tr>
          <tr>
            <th><label for="loc">지역</label></th>
            <td><input type="text" name="loc" id="loc" v-model="deptDetail.loc" /></td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2">
              <input type="button" value="등록" @click="registerDept()"/>
              <input type="button" value="수정" @click="modifyDept()"/>
              <input type="button" value="삭제" @click="deleteDept()"/>
              <input type="reset" value="취소" />
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
    <form method="post" class="row">
      <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>사원번호</th>
            <th>사원이름</th>
            <th>직무</th>
            <th>월급여</th>
            <th></th>
          </tr>
        </thead>
        <template v-if="deptDetail.emps != null && deptDetail.emps[0].empno == 0">
          <tbody>
            <tr>
              <td colspan="5">배치된 사원이 없습니다.</td>
            </tr>
          </tbody>
        </template>
        <template v-else>
          <tbody>
            <tr v-for="emp in deptDetail.emps" :key="emp.no">
              <td>{{ emp.empno }}</td>
              <td>{{ emp.ename }}</td>
              <td>{{ emp.job }}</td>
              <td>{{ emp.sal }}</td>
              <td>
                <input type="checkbox" name="empno" :value="emp.empno" v-model="check" />
              </td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="5">
                <input type="button" value="삭제" @click="deleteEmps()"/>
                <input type="reset" value="취소" />
              </td>
            </tr></tfoot
        ></template>
      </table>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  props: {
    deptno: {
      type: Number,
      required: false,
      default: 10,
    },
  },
  data() {
    return {
      deptDetail: {},
      check: [],
    };
  },
  methods: {
    getDeptDetail() {
      axios.get(`http://127.0.0.1:8080/api/depts/${this.deptno}/emps`).then((response) => {
        this.deptDetail = response.data;
      });
    },
    registerDept() {
      axios.post(`http://127.0.0.1:8080/api/depts`,this.deptDetail)
        .then((response) => {
          this.deptDetail = response.data;
          this.$emit("modify-dept");
        });
    },
    modifyDept() {
      axios.put(`http://127.0.0.1:8080/api/depts/${this.deptno}`,this.deptDetail)
        .then((response) => {
          this.deptDetail = response.data;
          this.$emit("modify-dept");
        });
    },
    deleteDept() {
      axios.delete(`http://127.0.0.1:8080/api/depts/${this.deptno}`).then(() => {
        this.deptDetail = {};
          this.$emit("modify-dept");
        });
    },
    deleteEmps() {
      console.log(this.check);
      axios.delete(`http://127.0.0.1:8080/api/emps/${this.check}`)
        .then(() => {
          this.getDeptDetail();
        });
    }
  },
  watch: {
    deptno() { //deptno가 변경되는걸 watch
      this.getDeptDetail();
    },
  },
  created() {
    // this.deptno = new URLSearchParams(window.location.search).get("deptno");
    this.getDeptDetail();
  },
};
</script>

<style></style>