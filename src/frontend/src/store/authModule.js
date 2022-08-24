
import AuthService from "@/services/auth.service";
const user = JSON.parse(localStorage.getItem('user'));
const initialState = user
    ? { status: { loggedIn: true }, user }
    : { status: { loggedIn: false }, user: null };



export const authModule = {
    namespaced: true,
    state:  initialState,


    actions: {
        login({commit}, user){

            return AuthService.login(user).then(
                user => {
                    console.log("User: "+user.data)
                    commit('loginSuccess', user);
                    commit('setAuthenticate', true,  {root: true});
                    commit('setToken', true,  {root: true});
                    return Promise.resolve(user);
                },
                error => {
                    commit('loginFailure');
                    console.log(error)
                    return Promise.reject(error);
                }
            );
        },

        logout({commit}){
            AuthService.logout();
            commit('setAuthenticate', false, {root: true});
            commit('logout');
        },

        register({commit}, user) {
            return AuthService.registration(user).then(
                response => {
                    commit('registerSuccess');
                    return Promise.resolve(response.data);
                },
                error => {
                    commit('registerFailure');
                    return Promise.reject(error);
                }
            );
        }
    },

    mutations: {
        loginSuccess(state, user) {

            state.status.loggedIn = true;
            state.user = user;
        },

        loginFailure(state) {
            state.status.loggedIn = false;
            state.user = null;
        },

        logout(state) {
            state.status.loggedIn = false;
            state.user = null;
        },

        registerSuccess(state) {
            state.status.loggedIn = false;
        },

        registerFailure(state) {
            state.status.loggedIn = false;
        },





    }
}