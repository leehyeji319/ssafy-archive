export default {
  template: `<div>
    {{no}}번 게시물 상세정보
    <router-link to="/board">목록</router-link>
   </div>`,
  data() {
    return {
      no: 0,
    };
  },
  created() {
    console.dir(this.$router); // 라우터 전체의 정보
    console.dir(this.$route); // 현재 호출된 해당 라우터 정보
    console.log(this.$route.params.no); //쿼리는 그냥 query
    console.log(this.$route.path); //  /board/1
    this.no = this.$route.params.no;
  },
};
