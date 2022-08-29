import Main from "@/pages/Main";
import {createRouter, createWebHistory} from "vue-router/dist/vue-router";
import WebSocketGreetings from "@/components/WebSocketGreetings";
import Login from "@/pages/Login";
import Registration from "@/pages/Registration";
import Chat from "@/pages/Chat";


const routes = [

    {
        path: "/hello",
        component: Chat,
        name: "hello",
    },

    {
        path: '/chat',
        component: WebSocketGreetings,
        name: 'chat'
    },


    {
        path: '/auth/login',
        name: "login",
        component: Login,
        meta: {guest: true }
    },

    {
        path: '/auth/singup',
        name: "singup",
        component: Registration,
        meta: {guest: true }
    },


];

const router = createRouter({
    routes,
    history: createWebHistory(),

});

router.beforeEach((to, from, next) => {


    const publicPages = ['/auth/login', '/auth/singup'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('user');


    console.log(loggedIn)


    if ( (authRequired && !loggedIn) || to.path === '/') {
        next('/auth/login');
    }
    else if (loggedIn && !authRequired){
        next('/hello')
    }
    else {
        next();
    }
});




export default router;