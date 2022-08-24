export default function authHeader() {
    let user = JSON.parse(localStorage.getItem('user'));

    console.log('Bearer ' + user.accessToken )
    if (user && user.accessToken) {
        console.log('Bearer ' + user.accessToken )
        return { Authorization: 'Bearer ' + user.accessToken };
    } else {
        return {};
    }
}
