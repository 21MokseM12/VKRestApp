package org.app.Controllers;


public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        String token = TokenGenerator.generateToken(login, password);
        return token;
    }

//    public void setToken(String token) {
//        this.token = token;
//    }
}
