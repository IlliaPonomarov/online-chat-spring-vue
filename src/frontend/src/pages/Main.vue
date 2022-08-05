<template>
  <div class="bg-white">

    <my-chat></my-chat>
  </div>
</template>

<script>
import store from '../store/index'
import MyChat from "@/pages/Chat";

export default {
  name: 'main-page',
  components: {MyChat},
  computed: {
    currentUser(){
      console.log(store.state.auth.user)
      return this.$store.state.auth.user;
    }
  },


  methods: {
    logout(){
      this.$store.dispatch('auth/logout').then(
          () => {
            this.$router.push('/auth/login')
          },

      );
    }
  }
}
</script>

<style scoped>

</style>