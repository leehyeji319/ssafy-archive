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
            <th>부서이름</th>
            <th>위치</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="depts.length == 0">
            <td colspan="4">등록된 사용자 정보가 없습니다.</td>
          </tr>
          <template v-else>
            <tr
              v-for="(dept, index) in depts"
              :key="dept.deptno"
              @click="pickDept(dept.deptno)"
            >
              <td>{{ index + 1 }}</td>
              <td>{{ dept.deptno }}</td>
              <td>{{ dept.dname }}</td>
              <td>{{ dept.loc }}</td>
            </tr>
          </template>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="4">
              <div class="btn btn-success text-center" @click="changeForm">
                등록
              </div>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>

<script>
import restApi from "@/util/http-common.js";
export default {
  data() {
    return {
      depts: [],
    };
  },
  props: {
    refresh: {
      type: Number,
      default: 0,
    },
  },
  methods: {
    getDepts() {
      restApi.get("/api/depts").then(({ data }) => {
        this.depts = data;
      });
    },
    pickDept(deptno) {
      this.$emit("select-dept", deptno);
      this.$router.push(`/dept/detail/${deptno}`)
    },
    changeForm() {
      this.$router.push('/dept/regForm'); //여기서 슬래시 안붙이면 다 상대경로가 된다. 주의! 
    },
  },
  created() {
    this.getDepts();
  },
  watch: {
    refresh() {
      this.getDepts();
    },
    //경로는 바꼈으니 WATCH를 건다
    $route(to) { //새로이동할 밸류가 to, 바뀌기전 이전 라우터 정보 from
      console.log("DeptList watch route");
      if (to.path == "/dept") { //그녀석의 패쓰가 /dept때만 데이터를 갱신해라
        console.log("get Depts ...")
        this.getDepts();
      }
    }
  },
};
</script>

<style scoped>
</style>