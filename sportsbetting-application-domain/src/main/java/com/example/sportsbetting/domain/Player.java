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

/**
 *
 * @author Sanyi
 */
@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(name = "accountNumber")
    private Integer accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "birth", columnDefinition = "DATE")
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Player() {
    }

    public Player(String name, Integer accountNumber, BigDecimal balance, LocalDate birth, Currency currency) {
        this.setName(name);
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
        this.setBirth(birth);
        this.setCurrency(currency);
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
}
