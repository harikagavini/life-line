import { jwtDecode } from "jwt-decode";

function isLoggedIn(token) {
    if (token) {
        const decodedToken = jwtDecode(token);
        const currentTime = Date.now() / 1000;
        if (decodedToken.exp < currentTime) {
            return false;
        }
        return true;
    }
    return false;
}

export default isLoggedIn;