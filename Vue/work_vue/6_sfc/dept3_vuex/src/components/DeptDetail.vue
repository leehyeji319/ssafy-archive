<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-info text-light text-center">부서 조회 with emps</h2>
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
                v-model.lazy="dept.deptno"
                :readonly="dept != null && dept.deptno"
              />
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
              <input type="button" value="수정" @click="modifyDept" class="btn btn-warning m-1" />
              <input
                type="button"
                value="삭제"
                v-if="!dept.emps || dept.emps.length == 0"
                @click="removeDept"
                class="btn btn-dark m-1"
              />
              <input type="reset" value="취소" class="btn btn-info m-1" />
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
        <template v-if="dept.emps != null && dept.emps.length > 0">
          <tbody>
            <tr v-for="emp in dept.emps" :key="emp.empno">
              <td>{{ emp.empno }}</td>
              <td>{{ emp.ename }}</td>
              <td>{{ emp.job }}</td>
              <td>{{ emp.sal }}</td>
              <td>
                <input type="checkbox" name="empno" :value="emp.empno" v-model="empnoList" />
              </td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="5">
                <input type="button" value="삭제" @click="removeEmps" class="btn btn-dark m-1" />
                <input type="reset" value="취소" class="btn btn-info m-1" />
              </td>
            </tr>
          </tfoot>
        </template>
        <tbody v-else>
          <tr>
            <td colspan="5">배치된 사원이 없습니다.</td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</template>

<script>
import Constant from "@/common/Constant";
import restApi from "@/util/http-common.js";
export default {
  props: [ //동적라우팅이 바뀌면 프롭스로 바뀐걸 넣어준다. 컴포넌트 입장에선 프롭스가 계속 변경되고있엇고,
     //그러니까 바꼇던 거야. -> 라우트를 watch처리
    "deptno"],
  data() {
    return {
      dept: {
        //수정하는데 
        // ...this.$store.state.dept //스프레드 연산자 를 쓰면 저걸 펼쳐서 똑같은 복사본을 만들잖아 ...
      },
      empnoList: [],
    };
  },
  methods: { //부서 수정, 삭제에 붙여볼게
    getDept() {
      if (this.deptno == 0) return;
      this.$store.dispatch(Constant.GET_DEPT, this.deptno) //가져오고 할일없으니까 then 콜백없어도됨
        .then(() => this.dept = { ...this.$store.state.dept });
    },
    removeEmps() {
      let params = "";
      this.empnoList.forEach((item) => (params += `empno=${item}&`));
      restApi.delete(`/api/emps?${params}`).then(({ status }) => {
        console.log(`removeEmps success : ${status}`);
        this.getEmps();
      });
    },
    getEmps() {
      restApi.get(`/api/emps?deptno=${this.dept.deptno}`).then(({ data }) => {
        this.dept.emps = data;
        this.empnoList = [];
      });
    },
    modifyDept() {
      this.$store.dispatch(Constant.MODIFY_DEPT, this.dept).then(() => {
        console.log(`modifyDept success`);
        this.$dispatch.dispatch(Constant.GET_DEPTS); //목록갱신이 피룡하다 
      });
    },
    removeDept() {
      restApi.delete(`/api/depts/${this.dept.deptno}`).then(() => {
        console.log(`removeDept success`);
        this.clear();
        this.$router.push("/dept");
      });
    },
    clear() {
      this.dept = {};
    },
  },
  watch: {
    deptno() {
      this.getDept();
    },
  },
  created() {
    this.getDept();
    console.log("DeptDetail created..");
  },
};
</script>

<style></style>
