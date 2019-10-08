/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import database.PlayerBuilder;

/**
 *
 * @author Sanyi
 */
public class User extends Player {

    private String email;
    private String password;

    public User(PlayerBuilder builder) {
        super(builder);
        this.email = builder.getEmail();
        this.password = builder.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
