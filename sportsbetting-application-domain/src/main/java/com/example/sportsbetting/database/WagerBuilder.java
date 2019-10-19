/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.database;


import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Wager;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Sanyi
 */
public class WagerBuilder {

    private BigDecimal amount;
    private LocalDateTime timeStampCreated;
    private boolean processed;
    private boolean win;
    private OutcomeOdd odd;
    private Player player;
    private Currency currency;

    public WagerBuilder amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public WagerBuilder timeStampCreated(LocalDateTime timeStampCreated) {
        this.timeStampCreated = timeStampCreated;
        return this;
    }

    public WagerBuilder processed(Boolean processed) {
        this.processed = processed;
        return this;
    }

    public WagerBuilder win(Boolean win) {
        this.win = win;
        return this;
    }

    public WagerBuilder odd(OutcomeOdd outcomeOdd) {
        this.odd = outcomeOdd;
        return this;
    }

    public WagerBuilder player(Player player) {
        this.player = player;
        return this;
    }

    public WagerBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Wager build() {
        return new Wager(amount,timeStampCreated,processed,win,odd,player,currency);
    }

}
