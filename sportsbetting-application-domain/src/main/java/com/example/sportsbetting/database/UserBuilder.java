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
public class UserBuilder {

    private String name;
    private Integer accountNumber;
    private BigDecimal balance;
    private LocalDate birth;
    private Currency currency;

    public UserBuilder accountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public UserBuilder balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public UserBuilder birth(LocalDate birth) {
        this.birth = birth;
        return this;
    }

    public UserBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public String getName() {
        return name;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Currency getCurrency() {
        return currency;
    }
}
