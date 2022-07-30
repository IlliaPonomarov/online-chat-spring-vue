
import axios from 'axios'
import authHeader from "@/services/authHeader";

const API_URL = 'http://localhost:8022/api/test'
class UserService {

    getAllPersons(){
        return axios.get(API_URL + '/all', {headers: authHeader()});
    }

    getPersonById(id){
        return axios.get(API_URL + '/user/' + id, {headers: authHeader()});
    }
}

export default new UserService();