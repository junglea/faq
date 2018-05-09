package com.junglea.faq.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;

@Document(collection="apiuser")
public class ApiUser {


    public static enum UserRole {
        ADMIN,
        READER,
        WRITER
    }

    @Id
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String role;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public void setRole(UserRole role) {
        this.role = role.toString();
    }

    public UserRole getRole() {
        return UserRole.valueOf(this.role);
    }

    public String getPassword() {
        return this.password;
    }
}
