import { createApp } from 'vue';
import App from './App.vue';
// eslint-disable-next-line no-unused-vars
import router from'@/router/router';
import components from '@/components/UI'
import $ from "jquery";
import Vue from 'Vue'
import './assets/tailwind.css'
import { library } from '@fortawesome/fontawesome-svg-core';
import VeeValidate from 'vee-validate';
window.jQuery = window.$ = $;
require("bootstrap/dist/css/bootstrap.min.css");
require("bootstrap/dist/js/bootstrap.min.js");

const app = createApp(App);

library.add(faHome, faUser, faUserPlus, faSignInAlt, faSingOutAlt);
Vue.config.productionTip = false;

components.forEach(component => {
    app.component(component.name, component)
})

app.use(router).use(VeeValidate).mount('#app')
