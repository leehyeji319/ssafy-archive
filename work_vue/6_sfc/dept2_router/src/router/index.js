import Vue from 'vue'
import VueRouter from 'vue-router'
import DeptView from '@/views/DeptView.vue'
import EmpView from '@/views/EmpView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/dept'
  },
  {
    path: '/dept',
    name: 'dept',
    component: DeptView,

    children: [ //자식들의 경로 매칭
      {
        path: 'regForm',
        component: () => import('@/components/DeptForm')
      },
      {
        path: 'detail/:deptno', //경로의 일부분이 동적으로 바뀐다. :이름
        props: true,
        component: () => import('@/components/DeptDetail')
      }
    ],
  },
  {
    path: '/emp',
    name: 'emp',
    component: EmpView,

    children: [
      {
        path: 'regForm',
        component: () => import('@/components/EmpForm')
      },
      {
        path: 'detail/:empno',
        props: true,
        component: () => import('@/components/EmpDetail')
      }
    ]

  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
