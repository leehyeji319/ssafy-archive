export const NAME = "SSAFY";

//default로 이름없이 기본값으로 딱 한개 내보낼 수 있다.
//더 내보내고 싶으면 그냥 export 구문 쓰면 됨! 
export default {
  add(a, b) {
    return a + b;
  },

  subtract(a, b) {
    return a - b;
  }
}