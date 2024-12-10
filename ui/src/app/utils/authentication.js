import { jwtDecode } from "jwt-decode";
import configuration from "@/app/config";

function isLoggedIn() {
    const token = configuration.token;
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

function signOut() {
    configuration.token = "";
    window.location.href = "/login";
}

// eslint-disable-next-line import/no-anonymous-default-export
export default {
    isLoggedIn,
    signOut
};
