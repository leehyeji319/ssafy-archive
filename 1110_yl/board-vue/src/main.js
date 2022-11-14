import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

Vue.config.productionTip = false;

new Vue({
  router, //그 라우터를 적용시켜라 
  store,
  render: (h) => h(App),
}).$mount("#app");
