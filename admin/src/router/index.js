import {createRouter , createWebHistory} from 'vue-router';
import Login from "../views/login.vue"
import Admin from "../views/admin.vue"
// vue 3.0 结合 vue-router 4.0创建路由新方式，使用typeScript语法引入方式
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes: [{
        path: "/",
        redirect: "/login",
    }, {
        path: "/login",
        component: Login
    }, {
        path: "/admin",
        component: Admin
    }]
});
export default router;