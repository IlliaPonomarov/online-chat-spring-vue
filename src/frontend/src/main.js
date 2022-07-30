import { createApp } from 'vue';
import App from './App.vue';
// eslint-disable-next-line no-unused-vars
import router from'@/router/router';
import components from '@/components/UI'
import $ from "jquery";
import './assets/tailwind.css'
import store from "@/store/index";

window.jQuery = window.$ = $;
require("bootstrap/dist/css/bootstrap.min.css");
require("bootstrap/dist/js/bootstrap.min.js");

const app = createApp(App);


components.forEach(component => {
    app.component(component.name, component)
})

app.use(router).use(store).mount('#app')
