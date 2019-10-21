/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Sanyi
 */
@Entity
public class Wager {

    @Id
    @GeneratedValue
    private int Id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "timeStampCreated", columnDefinition = "DATE")
    private LocalDateTime timeStampCreated;

    @Column(name = "processed")
    private boolean processed;

    @Column(name = "win")
    private boolean win;

    @OneToOne()
    private OutcomeOdd odd;

    @OneToOne()
    private Player player;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Wager() {
    }

    public Wager(BigDecimal amount, LocalDateTime timeStampCreated, boolean processed, boolean win, OutcomeOdd odd, Player player, Currency currency) {
        this.setAmount(amount);
        this.setTimeStampCreated(timeStampCreated);
        this.setProcessed(processed);
        this.setWin(win);
        this.setOdd(odd);
        this.setPlayer(player);
        this.setCurrency(currency);
    }

    public int getId() {
        return Id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public OutcomeOdd getOdd() {
        return odd;
    }

    public void setOdd(OutcomeOdd odd) {
        this.odd = odd;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeStampCreated() {
        return timeStampCreated;
    }

    public void setTimeStampCreated(LocalDateTime timeStampCreated) {
        this.timeStampCreated = timeStampCreated;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

}
