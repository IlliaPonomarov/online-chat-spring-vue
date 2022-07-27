import Main from "@/pages/Main";
import {createRouter, createWebHistory} from "vue-router/dist/vue-router";
import WebSocketGreetings from "@/components/WebSocketGreetings";

const routes = [
    {
        path: '/',
        component: Main,
    },

    {
        path: '/chat',
        component: WebSocketGreetings
    },


];

const router = createRouter({
    routes,
    history: createWebHistory()
});

export default router;