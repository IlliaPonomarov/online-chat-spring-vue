import {createStore} from "vuex";
import {authModule} from "@/store/authModule"

export default createStore({

    state : function (){
        return {
            isAuthenticated: false,
            isRegistration: false,
            token: ""
        }
    },
    modules: {
        auth: authModule,

    },

    mutations: {

        setToken(state, status){
            state.token = status;
        },
        setAuthenticate(state, status){
            state.isAuthenticated = status;

        },
        setRegistration(state, status){

            state.isRegistration = status;
            console.log(state.isRegistration)
        }
    }
})