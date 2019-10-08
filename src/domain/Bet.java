/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author Sanyi
 */
public class Bet {
    private String description;
    private SportEvent event;
    private List<Outcome> outcome;

    public List<Outcome> getOutcome() {
        return outcome;
    }

    public void setOutcome(List<Outcome> outcome) {
        this.outcome = outcome;
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
