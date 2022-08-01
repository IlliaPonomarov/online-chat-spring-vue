import Main from "@/pages/Main";
import {createRouter, createWebHistory} from "vue-router/dist/vue-router";
import WebSocketGreetings from "@/components/WebSocketGreetings";
import Login from "@/pages/Login";
import store from "@/store";



const routes = [

    {
        path: "/hello",
        component: Main,
        name: "hello",
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
    console.log(store.state.isAuthenticated);
    if(to.path !== '/auth/login' && !store.state.isAuthenticated) {
        next({ path: '/auth/login' });
    } else if (to.path === '/auth/login' && store.state.isAuthenticated) {
        console.log("test")
        next({ name: "hello"});
    }else
        next()
})





export default router;