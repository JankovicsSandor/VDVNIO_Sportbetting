/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.database;


import com.example.sportsbetting.domain.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Sanyi
 */
public class PlayerBuilder extends UserBuilder {

     private String email;
    private String password;

    public PlayerBuilder password(String password) {
        this.password = password;
        return this;
    }

    public PlayerBuilder email(String email) {
        this.email = email;
        return this;
    }
}
