<template>
    <div class="container mx-auto">
      <div class="min-w-full border rounded lg:grid lg:grid-cols-3">
        <div class="border-r border-gray-300 lg:col-span-1" style="background-color: #0088cc">
          <div class="mx-3 my-3">
            <div class="relative text-gray-600">
                <span class="absolute inset-y-0 left-0 flex items-center pl-2">
                  <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                       viewBox="0 0 24 24" class="w-6 h-6 text-gray-300">
                    <path d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
                  </svg>
                </span>
              <input type="search" class="block w-full py-2 pl-10 bg-gray-100 rounded outline-none" name="search"
                     placeholder="Search" required />
            </div>
          </div>

          <ul class="overflow-auto h-[32rem]">
            <li  v-for="chat in chats" :key="chat.id" >
              <div v-if="chats.title !== 'function String() { [native code] }' ">
                  <a
                      @click="selectChat(chat)"
                      class="flex items-center px-3 py-2 text-sm transition duration-150 ease-in-out border-b border-gray-300 cursor-pointer hover:bg-gray-100 focus:outline-none">
                    <img class="object-cover w-10 h-10 rounded-full"
                         src="https://cdn.pixabay.com/photo/2018/09/12/12/14/man-3672010__340.jpg" alt="username" />
                    <div class="w-full pb-2">
                      <div class="flex justify-between">
                        <span class="block ml-2 font-semibold text-white"> {{ chat.title }}</span>
                        <span class="block ml-2 text-sm text-gray-600">{{  chat.messageTime }}</span>
                      </div>


                      <div v-if="chat.messages.length !== 0">
                         <span class="block ml-2 text-sm text-gray-600">{{   chat.lastMessage }}</span>
                      </div>
                      <div v-else>
                        <span class="block ml-2 text-sm text-gray-600"> New Chat </span>
                      </div>
                    </div>
                  </a>
              </div>
<!--              <a-->
<!--                  class="flex items-center px-3 py-2 text-sm transition duration-150 ease-in-out bg-gray-100 border-b border-gray-300 cursor-pointer focus:outline-none">-->
<!--                <img class="object-cover w-10 h-10 rounded-full"-->
<!--                     src="https://cdn.pixabay.com/photo/2016/06/15/15/25/loudspeaker-1459128__340.png" alt="username" />-->
<!--                <div class="w-full pb-2">-->
<!--                  <div class="flex justify-between">-->
<!--                    <span class="block ml-2 font-semibold text-gray-600">Same</span>-->
<!--                    <span class="block ml-2 text-sm text-gray-600">50 minutes</span>-->
<!--                  </div>-->
<!--                  <span class="block ml-2 text-sm text-gray-600">Good night</span>-->
<!--                </div>-->
<!--              </a>-->

            </li>
          </ul>
        </div>

      <!--         START CHAT  -->

        <div class="hidden lg:col-span-2 lg:block bg-white">
          <div class="w-full">
            <div class="relative flex items-center p-3 border-b border-gray-300">
              <img class="object-cover w-10 h-10 rounded-full"
                   src="https://cdn.pixabay.com/photo/2018/01/15/07/51/woman-3083383__340.jpg" alt="username" />
              <span class="block ml-2 font-bold text-gray-600"> {{ selected_chat.title }}</span>
              <span class="absolute w-3 h-3 bg-green-600 rounded-full left-10 top-3">
                </span>
            </div>

<!--            -->
            <div class="relative w-full p-6 overflow-y-auto h-[40rem]">
              <ul class="space-y-2" v-for="messages in selected_chat.messages">




                <!--      YOUR MESSAGES        -->
                <div v-if="messages.sender === this.auth_user['username']">
                  <li class="flex justify-end">
                    <div class="relative max-w-xl px-4 py-2 text-gray-700 bg-gray-100 rounded shadow">
                      <span class="block">{{ messages.message }}</span>
                    </div>
                  </li>
                  <br/>
                </div>

                <!--     FRIEND MESSAGES           -->
                <div v-else>
                  <li class="flex justify-start">
                    <div class="relative max-w-xl px-4 py-2 text-gray-700 rounded shadow">
                      <span class="block">{{ messages.message }}</span>
                    </div>
                  </li>
                </div>
              </ul>
            </div>

            <div class="flex items-center justify-between w-full p-3 border-t border-gray-300">
              <button>
                <svg xmlns="http://www.w3.org/2000/svg" class="w-6 h-6 text-gray-500" fill="none" viewBox="0 0 24 24"
                     stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M14.828 14.828a4 4 0 01-5.656 0M9 10h.01M15 10h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
                </svg>
              </button>
              <button>
                <svg xmlns="http://www.w3.org/2000/svg" class="w-5 h-5 text-gray-500" fill="none" viewBox="0 0 24 24"
                     stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M15.172 7l-6.586 6.586a2 2 0 102.828 2.828l6.414-6.586a4 4 0 00-5.656-5.656l-6.415 6.585a6 6 0 108.486 8.486L20.5 13" />
                </svg>
              </button>

              <input type="text" placeholder="Message"
                     class="block w-full py-2 pl-4 mx-3 bg-gray-100 rounded-full outline-none focus:text-gray-700"
                     name="message" v-model="send_message"  required />
              <button>
                <svg xmlns="http://www.w3.org/2000/svg" class="w-5 h-5 text-gray-500" fill="none" viewBox="0 0 24 24"
                     stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M19 11a7 7 0 01-7 7m0 0a7 7 0 01-7-7m7 7v4m0 0H8m4 0h4m-4-8a3 3 0 01-3-3V5a3 3 0 116 0v6a3 3 0 01-3 3z" />
                </svg>
              </button>
              <button type="submit" @click="send">
                <svg class="w-5 h-5 text-gray-500 origin-center transform rotate-90" xmlns="http://www.w3.org/2000/svg"
                     viewBox="0 0 20 20" fill="currentColor">
                  <path
                      d="M10.894 2.553a1 1 0 00-1.788 0l-7 14a1 1 0 001.169 1.409l5-1.429A1 1 0 009 15.571V11a1 1 0 112 0v4.571a1 1 0 00.725.962l5 1.428a1 1 0 001.17-1.408l-7-14z" />
                </svg>
              </button>
             </div>
            </div>
          </div>
        </div>

      </div>

</template>

<script>
import SockJS from "sockjs-client";
import Stomp from "webstomp-client";
import AuthService from "@/services/auth.service";
import ChatService from "@/services/chat.service";
import axios from "axios";

export default {
  name: "MyChat",

  data() {
    return {
      received_messages: Array,
      your_messages: Array,
      selected_chat: Object,
      auth_user: JSON.parse(localStorage.getItem("user")),
      chats: [{
        id: Number,
        title: String,
        messageTime: Date,
        lastMessage: String,
        messageCount: Number,
        personList: Array,
        messages: Array
      }],
      person_id: Number,
      send_message: null,
      chat_messages: Map,
      connected: false,
      test: null
    };
  },
  methods: {

    selectChat(selected_chat){
      this.selected_chat = selected_chat;
    },

    changeLastMessage(){
      let index = this.chats.findIndex(object => {
        return object.id === this.selected_chat.id;
      });

      if (index !== -1)
        this.chats[index].lastMessage = this.selected_chat.messages[this.selected_chat.messages.length - 1].message;
    },


    logout(){
      this.$store.dispatch('auth/logout').then(
          () => {
            this.$router.push('/auth/login')
          },

      );
    },

    send() {

      let person= this.selected_chat.messages.find(message => message.sender === this.auth_user['username']);
     // this.changeLastMessage();
      this.selected_chat.lastMessage = this.send_message;

      console.log("Send message:" + this.send_message);
      if (this.stompClient && this.stompClient.connected && this.send_message !== null) {
        const msg = { name: this.send_message };
        console.log(JSON.stringify(msg));
        this.stompClient.send("/app/chat", JSON.stringify( {
          'id' : this.selected_chat.messages[this.selected_chat.messages.length - 1].id++,
          'message' :  this.send_message,
          'person_id' : person.person_id,
          'sender' : this.auth_user['username']
        }), {});

      }
      this.send_message = null;
    },

    connect() {

      this.socket = new SockJS("http://localhost:8022/gs-chat");
      this.stompClient = Stomp.over(this.socket);

      this.stompClient.connect(
          {"Authorization": "Bearer " + AuthService.getToken()},
          frame => {

            console.log("FUCK   " + frame)
            this.connected = true;
            this.stompClient.subscribe("/topic/chat", tick => {
              this.selected_chat.messages.push(JSON.parse(tick.body))
            });
          },
          error => {
            console.log(error.body);
            this.connected = false;
          }
      );
    },

    async getAllChats(){

      await axios.get( "http://localhost:8022/api/chats/",
          {headers: {Authorization: localStorage.getItem("Authorization")}}
      ).then(response => {

        for (let i = 0; i < response.data.length ; i++) {


          let dataChat = {
            id: response.data[i].id,
            title: response.data[i].title,
            messageTime: response.data[i].messageTime,
            lastMessage: response.data[i].lastMessage,
            messageCount: response.data[i].messageCount,
            personList: response.data[i].personList,
            messages: response.data[i].messages,
          };

          console.log(dataChat);

          this.chats.push(dataChat)
        }
      }).catch(error => {
        localStorage.removeItem("Authorization");
        localStorage.removeItem("user");
        console.log(error)
      });

      this.chats.splice(0, 1);

    },

    disconnect() {
      if (this.stompClient) {
        this.stompClient.disconnect();
      }
      this.connected = false;
    },

    tickleConnection() {
      this.connected ? this.disconnect() : this.connect();
    }
  },


 async mounted() {
   await this.getAllChats();

   if (this.chats.length !== 0)
     this.selected_chat = this.chats[0];

   this.connect();
  },
}
</script>

<style scoped>


</style>