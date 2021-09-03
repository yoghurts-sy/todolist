import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../views/Index";

Vue.use(VueRouter)


// 解决ElementUI导航栏中的vue-router在3.0版本以上重复点菜单报错问题
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}


const routes = [
  {
    path: '/',
    name: 'Index',
    component: Index
  },
 {
    path: '/register',
    name: 'register',
    component: () => import('../views/Register.vue')
  },
    {
        path: '/usrregis',
        name:'UserRegister',
        component: ()=> import('../views/UserRegister')
    }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
