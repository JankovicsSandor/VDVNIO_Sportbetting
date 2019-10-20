/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sanyi
 */
@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue
    private int Id;

    @Column("name")
    private String name;

    @Column("accountNumber")
    private Integer accountNumber;

    @Column("balance")
    private BigDecimal balance;

    @Column("birth")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Player() {
    }

    public Player(String name, Integer accountNumber, BigDecimal balance, LocalDate birth, Currency currency, User user) {
        this.setName(name);
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
        this.setBirth(birth);
        this.setCurrency(currency);
        this.setUser(user);
    }

    public int getId() {
        return Id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
