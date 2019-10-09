/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import database.WagerBuilder;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Sanyi
 */
public class Wager {

    private BigDecimal amount;
    private LocalDateTime timeStampCreated;
    private boolean processed;
    private boolean win;
    private OutcomeOdd odd;
    private Player player;
    private Currency currency;

    public Wager(BigDecimal amount, LocalDateTime timeStampCreated, boolean processed, boolean win, OutcomeOdd odd, Player player, Currency currency) {
       this.setAmount(amount);
       this.setTimeStampCreated(timeStampCreated);
       this.setProcessed(processed);
       this.setWin(win);
       this.setOdd(odd);
       this.setPlayer(player);
       this.setCurrency(currency);
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
