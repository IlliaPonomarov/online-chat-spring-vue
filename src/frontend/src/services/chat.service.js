const API_CHAT = "http://localhost:8022/api/chats";
const axios = require('axios').default;


class ChatService {
    async getAllChats(){

          let test = [];
          axios.get(API_CHAT + "/",
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

                  test.push(dataChat)
              }
          }).catch(error => alert(error));

      return test;

    }

}



export default new ChatService();