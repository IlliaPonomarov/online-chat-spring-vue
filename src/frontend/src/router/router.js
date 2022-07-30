import Main from "@/pages/Main";
import {createRouter, createWebHistory} from "vue-router/dist/vue-router";
import WebSocketGreetings from "@/components/WebSocketGreetings";
import Login from "@/pages/Login";

const routes = [
    {
        path: '/hello',
        component: Main,
    },

    {
        path: '/chat',
        component: WebSocketGreetings
    },

    {
        path: '/auth/login',
        component: Login
    },

];

const router = createRouter({
    routes,
    history: createWebHistory()
});

export default router;