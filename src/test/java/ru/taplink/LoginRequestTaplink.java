package ru.taplink;

public class LoginRequestTaplink {
    public static final String URL = "https://taplink.ru/api/auth/login.json";

    public static String getBody(String email, String password) {
        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\", \"token\": null, \"twofactor\": \"\" }";
    }
}
