<template>
  <div class="container">
    <div class="row mt-3">
      <h2 class="bg-primary text-light text-center">{{deptno}}부서 조회 with emps</h2>
    </div>
    <table class="table">
      <tbody>
        <tr>
          <th><label for="deptno">부서번호</label></th>
          <td><input type="text" v-model="dept.deptno" readonly="readonly" /></td>
        </tr>
        <tr>
          <th><label for="dname">부서이름</label></th>
          <td><input type="text" v-model="dept.dname" /></td>
        </tr>
        <tr>
          <th><label for="loc">지역</label></th>
          <td><input type="text" v-model="dept.loc" /></td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="2">
            <input type="submit" value="수정" />
            <input type="submit" value="삭제" />
            <input type="reset" value="취소" />
          </td>
        </tr>
      </tfoot>
    </table>
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
      <template v-if="dept.emps.length > 0">
        <tbody>
          <tr v-for="emp in dept.emps" :key="emp.empno">
            <td>{{ emp.empno }}</td>
            <td>{{ emp.ename }}</td>
            <td>{{ emp.job }}</td>
            <td>{{ emp.sal }}</td>
            <td><input type="checkbox" name="empno" :value="emp.empno" /></td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="5">
              <input type="submit" value="삭제" />
              <input type="reset" value="취소" />
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
  </div>
</template>

<script>
  import axios from 'axios';
  export default {
    props: {
      deptno: {
        type: Number,
        requeired: false,
        default: 10
      },
    },
    data() {
      return {
        dept: {
          emps: []
        }
      }
    },
    methods: {
      getDept() {
        axios.get(`http://localhost:8080/api/depts/${this.deptno}/emps`)
          .then(({ data }) => this.dept = data)
      },
    }, 
    watch: {
      deptno() {
        this.getDept();
      },
    },
    created() {
      this.getDept();
    },
  }
</script>

<style scoped>

</style>