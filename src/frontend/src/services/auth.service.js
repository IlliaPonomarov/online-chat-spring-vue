import axios from 'axios';

const API_URL = 'http://localhost:6666/auth';


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


    logout(){
        localStorage.removeItem('user');
    }

    registration(user){
        return axios.post(API_URL + "/registration", {
            username: user.username,
            yearOfBirth: user.yearOfBirth,
            password: user.password
        })
    }
}

export default new AuthenticationService();