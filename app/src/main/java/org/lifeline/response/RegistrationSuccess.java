package org.lifeline.response;

import org.springframework.stereotype.Component;

@Component
public class RegistrationSuccess {
    private String message;
    private boolean success;

    public RegistrationSuccess() {
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

