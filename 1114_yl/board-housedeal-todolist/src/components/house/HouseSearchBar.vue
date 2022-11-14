<template>
  <b-row class="mt-4 mb-4 text-center">
    <!-- <b-col class="sm-3">
      <b-form-input
        v-model.trim="dongCode"
        placeholder="동코드 입력...(예 : 11110)"
        @keypress.enter="sendKeyword"
      ></b-form-input>
    </b-col>
    <b-col class="sm-3" align="left">
      <b-button variant="outline-primary" @click="sendKeyword">검색</b-button>
    </b-col> -->
    <b-col class="sm-3">
      <!-- sidos가 바뀌면 options로 자동으로 부트스트랩이 돌려준다. -->
      <b-form-select v-model="sidoCode" :options="sidos" @change="gugunList"></b-form-select>
    </b-col>
    <b-col class="sm-3">
      <b-form-select v-model="gugunCode" :options="guguns" @change="searchApt"></b-form-select>
    </b-col>
  </b-row>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "HouseSearchBar",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
    };
  },
  computed: {
    ...mapState(["sidos", "guguns", "houses"]), //여기 siods가 바뀌면 위에 options와 연결되어있음
    // sidos() {
    //   return this.$store.state.sidos;
    // },
  },
  created() {
    // this.$store.dispatch("getSido");
    // this.sidoList();
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_APT_LIST();
    this.getSido();
    //비동기로 넘어와야하니까 actions, 카멜케이스니까 actions네? 근데 dispatch가 없고 그냥썻네? ...Actions를 쓰면되지
  },
  methods: {
    //아 그냥 쓰고싶으면 ...mapActions 쓰면 되겟지!! $ 내부객체니까 안좋다고~
    ...mapActions(["getSido", "getGugun", "getHouseList"]),
    ...mapMutations(["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_APT_LIST"]),
    // sidoList() {
    //   this.getSido();
    // },
    gugunList() {
      // console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST(); //기존에 있떤거는지워버려라. 안그러면 계속 쌓이니까
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode); //이 메서드는 mapActions에서 가져옴
      //여기 this.getGugun 에서 axios호출
    },
    searchApt() { //여기서 또 axios로 받아오겟네
      if (this.gugunCode) this.getHouseList(this.gugunCode);
    },
  },
};
</script>

<style></style>
