import Main from "@/pages/Main";
import {createRouter, createWebHistory} from "vue-router/dist/vue-router";
import WebSocketGreetings from "@/components/WebSocketGreetings";
import Login from "@/pages/Login";
import Registration from "@/pages/Registration";



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
    console.log(authRequired)
    const loggedIn = localStorage.getItem('user');
    // trying to access a restricted page + not logged in
    // redirect to login page
    if (authRequired && !loggedIn) {
        next('/auth/login');
    } else {
        next();
    }
});




export default router;