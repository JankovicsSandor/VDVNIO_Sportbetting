/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public class Outcome {

    public Outcome(String description, Bet bet, List<OutcomeOdd> outcomeOdds) {
        this.setDescription(description);
        this.setBet(bet);
        this.setOutcomeOdds(outcomeOdds);
    }

    private String description;
    private Bet bet;
    private List<OutcomeOdd> outcomeOdds;

    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }

    public void setOutcomeOdds(List<OutcomeOdd> outcomeOdd) {
        for (OutcomeOdd oddValue : outcomeOdd) {
            oddValue.setOutcome(this);
        }
        this.outcomeOdds = outcomeOdd;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
