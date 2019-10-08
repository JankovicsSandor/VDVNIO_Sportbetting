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

    public Bet() {
        this.winnerOutcomes = new ArrayList<Outcome>();
    }

    public Bet(BetBuilder builder) {
        this.description = builder.getDescription();
        this.event = builder.getEvent();
        this.winnerOutcomes = builder.getWinnerOutcomes();
        this.type = builder.getType();
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
