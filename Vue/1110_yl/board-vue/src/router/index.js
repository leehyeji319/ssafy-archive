import Vue from "vue";
import VueRouter from "vue-router";
import AppMain from "@/views/AppMain";
import AppUser from "@/views/AppUser";
//여기등록하면 한번에 읽어온다

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/user",
    name: "user",
    component: AppUser,
  },
  {
    path: "/board", //게시판은 필요할때마다 불러와볼게~
    name: "board",
    //얘의 이름은 board야 
    component: () => import("@/views/AppBoard.vue"), //만나는순간에 읽어온다
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "boardlist", //페이지번호는 쿼리로 넘기겠죠
        component: () => import("@/components/board/BoardList"),
      },
      {
        path: "write", //프롭스로 객체 넘길꺼죠?
        name: "boardwrite",
        component: () => import("@/components/board/BoardWrite"),
      },
      {
        path: "view/:articleno", //글번호 넘겨야함
        name: "boardview",
        component: () => import("@/components/board/BoardView.vue"),
      },
      {
        path: "modifiy/:articleno",
        name: "boardmodify",
        component: () => import("@/components/board/BoardModify"),
      },
      {
        path: "delete",
        name: "boarddelete",
        //얘의 이름은 board야 
        component: () => import("@/components/board/BoardDelete"),
      },
    ]
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
