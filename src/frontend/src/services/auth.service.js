import axios from 'axios';

const API_URL = 'http://localhost:8022/auth';


class AuthenticationService {
    login(user){
        return axios.post(API_URL + "/login", {
            username: user.username,
            password: user.password
        })
            .then(response => {
                if (response.data.accessToken){
                    localStorage.setItem('user', JSON.stringify(response.data));
                }
                return response.data;
            });
    }

   async token(){

        const response = await  axios.get(API_URL+"/token");

        return response.data;
    }

    logout(){
        localStorage.removeItem('user');
    }

    registration(user){
        console.log(7777777)
        return axios.post(API_URL + "/registration", {
            username: user.username,
            yearOfBirth: user.yearOfBirth,
            password: user.password,
            email: user.email
        })
    }
}

export default new AuthenticationService();