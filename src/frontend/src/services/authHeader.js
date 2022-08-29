export default function authHeader() {
    let user = JSON.parse(localStorage.getItem('user'));

    console.log('Bearer ' + user.token )
    if (user && user.token) {
        console.log('Bearer ' + user.token )
        return { Authorization: 'Bearer ' + user.token };
    } else {
        return {};
    }
}
