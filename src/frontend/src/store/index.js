import {createStore} from "vuex";
import {loginModule} from "@/store/loginModule"

export default createStore({
    modules: {
        user: loginModule
    },
})