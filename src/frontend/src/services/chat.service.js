import axios from "axios";
const API_CHAT = "http://localhost:8022/api/chat"
class ChatService {

    getAllChats(){
        return axios.get(API_CHAT + "/all");
    }

}



export default new ChatService;