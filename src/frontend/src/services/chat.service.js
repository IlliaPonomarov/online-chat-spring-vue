import axios from "axios";
const API_CHAT = "http://localhost:8022/api/chats";
let user = JSON.parse(localStorage.getItem('user'));
class ChatService {

    getAllChats(){

      let promise = axios.get(API_CHAT + "/",
          {headers: {Authorization: localStorage.getItem("Authorization")}}
      ).then(response => {
           return response.data}).catch(error => alert(error));


      let test = new Array();

      Promise.all([promise]).then(function (values){
          for (let i = 0; i < values.length; i++) {
              Array.prototype.push.apply(test, values[i]);
          }
      });


      return test;

    }

}



export default new ChatService();