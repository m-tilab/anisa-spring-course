package com.example.springbootrest.model.response;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("Missing required field. please check");

    private String errorMessage;

    ErrorMessages(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
