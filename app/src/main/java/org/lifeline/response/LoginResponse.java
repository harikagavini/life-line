package org.lifeline.response;

import org.springframework.stereotype.Component;

@Component
public class LoginResponse {
    private String message;
    private boolean success;

    public LoginResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}


