<template>
  <div className="bg-white flex items-stretch bg-grey-lighter min-h-screen">

  </div>
</template>

<script>
import store from '../store/index'
import ChatService from "@/services/chat.service";

export default {
  name: 'main-page',
  data() {
    return{
      chats: [{
        id: Number,
        title: String,
        messageTime: String,
        lastMessage: String,
        messageCount: Number,
        personList: Array,
        messages: Array
      }],
    }
  },

  computed: {
    currentUser() {
      console.log(store.state.auth.user)
      return this.$store.state.auth.user;
    }
  },
  methods: {
    logout() {
      this.$store.dispatch('auth/logout').then(
          () => {
            this.$router.push('/auth/login')
          },
      );
    }

  },

  mounted() {
   // this.$store.commit('setChats', ChatService.getAllChats());
   this.chats = ChatService.getAllChats();
  }

}
</script>

<style scoped>
</style>