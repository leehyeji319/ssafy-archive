import axios from "axios";


export default axios.create({ //axios의 객체
  baseURL: "http://localhost:9999/vue",
  headers: {
    "Content-Type": "application/json",
  }
});