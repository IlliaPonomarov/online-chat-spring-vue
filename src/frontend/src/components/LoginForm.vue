<template>
  <div >
    <div class="flex items-center justify-center min-h-full ">
      <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
        <div class="flex justify-center">
          <svg xmlns="http://www.w3.org/2000/svg" class="w-20 h-20 text-blue-600" fill="none" viewBox="0 0 24 24"
               stroke="currentColor">
            <path d="M12 14l9-5-9-5-9 5 9 5z" />
            <path
                d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z" />
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                  d="M12 14l9-5-9-5-9 5 9 5zm0 0l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14zm-4 6v-7.5l4-2.222" />
          </svg>
        </div>
        <h3 class="text-2xl font-bold text-center">Login to your account</h3>

      <!-- LOGIN FORM-->
        <form name="form" @submit.prevent="handleLogin" >
          <div class="mt-4">



            <div>
              <label class="block" for="username">Username</label>
              <input
                      id="username"
                      type="text"
                      v-model="user.username"
                       placeholder="Username"
                       class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">



            </div>


            <div class="mt-4">
              <label class="block">Password</label>
                <input
                    v-model="user.password"
                    type="password"
                    placeholder="Password"
                    class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
            </div>

            <div v-if="this.message.length > 0">
              <span class="text-xs tracking-wide text-red-600"> {{ this.message }} </span>
            </div>


            <div class="flex items-baseline justify-between">
              <button :disabled="loading" class="px-6 py-2 mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Login</button>
              <a href="#" class="text-sm text-blue-600 hover:underline">Forgot password?</a>
            </div>


          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import User from '../model/user'
import {mapActions} from 'vuex'
export default {
  name: "LoginForm",

  data(){
    return {
      user: new User('', ''),
      loading: false,
      message: ''
    };
  },


  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },


  },
    mounted(){
      if (this.loggedIn)
        this.$router.push('/hello')

  },



  methods: {

    handleLogin() {
      this.loading = true;

      if (this.user.username === undefined || this.user.password === undefined) {
        this.message = "Incorrect Username or Password!"
        this.loading = false;
      }



      if (this.user.username && this.user.password){
        this.$store.dispatch('auth/login', this.user).then(
            () => {
              this.$router.push('/hello');
            },
            errors => {
              this.loading = false;
              this.message  = (errors.response && errors.response.data) || errors.message || errors.toString();
            }
        )
      }



    },

    ...mapActions({
      auth: "auth/login"
    })
  }



}
</script>

<style scoped>

</style>