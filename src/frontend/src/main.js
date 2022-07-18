import { createApp } from 'vue'
import App from './App.vue'


import $ from "jquery";
window.jQuery = window.$ = $;
require("bootstrap/dist/css/bootstrap.min.css");
require("bootstrap/dist/js/bootstrap.min.js");

createApp(App).mount('#app')
