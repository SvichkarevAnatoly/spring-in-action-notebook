package com.example.other;

public class Email {
    private String email;
    private boolean validEmail;

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public boolean isValidEmail() {
        return validEmail;
    }

    public void setValidEmail(boolean validEmail) {
        this.validEmail = validEmail;
    }
}
