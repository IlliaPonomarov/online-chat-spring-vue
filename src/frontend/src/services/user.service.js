
import axios from 'axios'
import authHeader from "@/services/authHeader";

const API_URL = 'http://localhost:8022/api/user'
class UserService {

    getAllPersons(){
        return axios.get(API_URL + '/', {headers: authHeader()});
    }

    getPersonById(id){
        return axios.get(API_URL + '/' + id, {headers: authHeader()});
    }
}

export default new UserService();