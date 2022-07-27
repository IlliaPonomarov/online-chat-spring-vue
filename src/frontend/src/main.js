import { createApp } from 'vue';
import App from './App.vue';
// eslint-disable-next-line no-unused-vars
import router from'@/router/router';

import $ from "jquery";
import './assets/tailwind.css'
window.jQuery = window.$ = $;
require("bootstrap/dist/css/bootstrap.min.css");
require("bootstrap/dist/js/bootstrap.min.js");

const app = createApp(App);

app.use(router).mount('#app')
