import axios from 'axios';

const API_URL = 'http://localhost:8022/auth';


class AuthenticationService {
    login(user){
        return axios.post(API_URL + "/login", {
            username: user.username,
            password: user.password
        })
            .then(response => {

                if (response.data.token){
                    console.log("test token")
                    localStorage.setItem('user', JSON.stringify(response.data));
                    localStorage.setItem('Authorization',`Bearer ${JSON.stringify(response.data.token)}`);
                }
                return response.data;
            });
    }

   getToken(){

        const response = axios.get(API_URL+"/token");

        return response.data;
    }

    logout(){
        localStorage.removeItem('user');
        localStorage.removeItem('Authorization');
    }

    registration(user){
        return axios.post(API_URL + "/registration", {
            username: user.username,
            yearOfBirth: user.yearOfBirth,
            password: user.password,
            email: user.email
        })
    }
}

export default new AuthenticationService();