import {createStore} from "vuex";
import {authModule} from "@/store/authModule"

export default createStore({

    state : function (){
        return {
            isAuthenticated: false,
        }
    },
    modules: {
        auth: authModule,

    },

    mutations: {

        setAuthenticate(state, status){
            state.isAuthenticated = status;
        }
    }
})