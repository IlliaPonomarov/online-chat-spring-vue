<template>
  <div >
    <div class="flex items-center justify-center min-h-full ">
      <div class="px-8 py-6 mt-4 text-left bg-white shadow-lg">
        <div class="flex justify-center">

          <!--          class="w-20 h-20 text-blue-600" fill="none" viewBox="0 0 24 24-->


          <i class="fa fa-telegram w-30 h-20 text-blue-600" fill="none" viewBox="0 0 24 24"  style="font-size:68px;"></i>



        </div>
        <h3 class="text-2xl font-bold text-center">Sing In</h3>

        <!-- LOGIN FORM-->
        <form name="form" @submit.prevent="handleLogin" >
          <div class="mt-4">



            <div>
              <label class="block" for="username">Username</label>
              <input
                  id="username"
                  type="text"
                  v-model="this.user.username"
                  placeholder="Username"
                  class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
            </div>



            <!-- written v-model for email-->
            <div class="mt-4">
            <label for="email" class="block">Email</label>
            <input
                v-model="this.user.email"
                id="email"
                type="email"
                placeholder="Email"
                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
          </div>

            <!-- written v-model for YEAR OF BIRTH-->

            <div class="mt-4">
              <label class="block">Year of Birth</label>
              <input
                  v-model="this.user.yearOfBirth"
                  type="text"
                  placeholder="Year of Birth"
                  class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
            </div>

            <div class="mt-4">
              <label class="block">Password</label>
              <input
                  v-model="this.user.password"
                  type="password"
                  placeholder="Password"
                  class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
            </div>

            <div class="mt-4">
              <label class="block">Repeat Password</label>
              <input
                  v-model="this.repeatPassword"
                  type="password"
                  placeholder="Repeat Password"
                  class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
            </div>

            <div v-if="this.user.password !== this.repeatPassword">
              <span class="text-xs tracking-wide text-red-600"> Passwords should be equals </span>

            </div>

            <div v-if="this.message.length > 0">
              <span class="text-xs tracking-wide text-red-600"> {{ this.message }} </span>
            </div>


            <div class="flex items-baseline justify-between">
              <button :disabled="loading" class="px-6 py-2 mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Sing Up</button>

            </div>
            <div class="ml-5">
              <router-link class="text-sm text-blue-600 hover:underline" to="/auth/login">Sing In</router-link>
            </div>



          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import User from '../model/user'
import {mapActions, mapState} from 'vuex'
export default {
  name: "sing-up",

  data(){
    return {
      user: new User('', '', '', ''),
      loading: false,
      repeatPassword: '',
      message: '',
      submitted: false,
      successful: false,
    };
  },


  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },

    ...mapState({
      singup: state => state.isRegistration
    })


  },
  mounted(){
    if (this.successful)
      this.$router.push({path: '/auth/login'})

  },





  methods: {



    handleLogin() {
      this.loading = true;

      this.$store.dispatch("auth/register", this.user).then(
        data => {
          console.log(this.user.toString())
          this.message = data.message;
          this.successful = true;
          this.$router.push({path: '/auth/login'})
        },

          errors => {
              this.message = (errors.response && errors.response.data) || errors.message || errors.toString();
              this.successful = false;
          }
      );

    },

    ...mapActions({
      auth: "auth/login",
      auth2: "auth/register"
    })
  }



}
</script>

<style scoped>

</style>