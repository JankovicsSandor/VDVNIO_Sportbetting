/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Bet;
import domain.OutcomeOdd;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public class OutcomeBuilder {

    public OutcomeBuilder() {
        this.outcomeOdds = new ArrayList<OutcomeOdd>();
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public Bet getBet() {
        return bet;
    }

    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }
    private Bet bet;
    private List<OutcomeOdd> outcomeOdds;

    public OutcomeBuilder description(String description) {
        this.description = description;
        return this;
    }

    public OutcomeBuilder description(Bet bet) {
        this.bet = bet;
        return this;
    }

    public OutcomeBuilder description(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
        return this;
    }

}
