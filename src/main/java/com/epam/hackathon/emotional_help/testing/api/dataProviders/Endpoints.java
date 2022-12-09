package com.epam.hackathon.emotional_help.testing.api.dataProviders;

public enum Endpoints {

    SIGN_UP("auth/sign-up"),
    SIGN_IN("auth/sign-in"),
    LOGOUT("users/logout"),
    CURRENT("users/current"),
    EMOTIONAL_MAP("emotional-maps"),
    QUESTIONAIRES("questionnaires");

    private final String text;

    Endpoints(String endpoint) {
        this.text = endpoint;
    }

    public String getEndpoint() {
        return text;
    }
}
