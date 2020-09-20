import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/login.vue"
import Admin from "../views/admin.vue"
import Welcome from "../views/admin/welcome.vue"
import Chapter from "../views/admin/chapter.vue"
Vue.use(VueRouter)

const routes = [{
    path: "/",
    redirect: "/login",
  }, {
    path: "/login",
    component: Login
  }, {
    path: "/admin",
    component: Admin,
    // 子路由
    children:[
      {
        path:"welcome",
        component:Welcome,
        name:"welcome"
      },
      {
        path:"business/chapter",
        component:Chapter,
        name:"business/chapter"
      }
    ]
  }];
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
