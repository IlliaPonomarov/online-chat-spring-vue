import Main from "@/pages/Main";
import {createRouter, createWebHistory} from "vue-router/dist/vue-router";
import WebSocketGreetings from "@/components/WebSocketGreetings";
import Login from "@/pages/Login";
import store from "@/store";



const routes = [

    {
        path: "/",
        component: Main,
        children: [{
            path: '/chat',
            component: WebSocketGreetings,
            auth: true
        }
        ]
    },


    {
        path: '/auth/login',
        name: "login",
        component: Login,
        meta: {guest: true }
    },


];

const router = createRouter({
    routes,
    history: createWebHistory(),

});

router.beforeEach((to, from, next) => {
    if(to.path !== '/auth/login' && !store.state.auth.isAuthenticated) {
        next({ path: '/auth/login' })
    } else if ((to.path === '/login' || to.path === 'login') && store.state.auth.isAuthenticated) {
        next({ path: '/' })
    }else
        next()
})





export default router;