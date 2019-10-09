/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import database.BetBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanyi
 */
public class Bet {

    public Bet(String description, SportEvent event, List<Outcome> winnerOutcomes, BetType type) {
        this.description = description;
        this.event = event;
        this.winnerOutcomes = winnerOutcomes;
        this.type = type;
    }
   
    private String description;
    private SportEvent event;
    private List<Outcome> winnerOutcomes;
    private BetType type;

    public BetType getBettype() {
        return type;
    }

    public void setBettype(BetType bettype) {
        this.type = bettype;
    }

    public List<Outcome> getWinnerOutcome() {
        return winnerOutcomes;
    }

    public void setWinnerOutcome(List<Outcome> outcome) {
        for (Outcome element : outcome) {
            element.setBet(this);
        }
        this.winnerOutcomes = outcome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SportEvent getEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }

}
