package com.epam.hackathon.emotional_help.testing.api.dataProviders;

public final class SharedTestData {

    private static String username;
    private static String password;
    private static String email;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        SharedTestData.token = token;
    }

    private static String token;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SharedTestData.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        SharedTestData.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        SharedTestData.email = email;
    }
}