package ggn.home.help.web;

public @interface Web {

    @interface Keys {
        String PASSWORD = "password";
        String LOGIN = "login";
        String EMAIL = "email";
        String USERNAME = "username";
    }

    @interface Path {
        String BASE_URL = "https://farmx.co.in:4068/";  //Staging
        String SIGN_IN = "users/signin";
    }
}