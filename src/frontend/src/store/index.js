import {createStore} from "vuex";
import {authModule} from "@/store/authModule"

export default createStore({
    modules: {
        auth: authModule,

    },
})