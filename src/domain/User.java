/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import database.PlayerBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Sanyi
 */
public class User extends Player {

    private String email;
    private String password;

    public User(String email, String password, String name, Integer accountNumber, BigDecimal balance, LocalDate birth, Currency currency, User user) {
        super(name, accountNumber, balance, birth, currency, user);
        this.email = email;
        this.password = password;
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
