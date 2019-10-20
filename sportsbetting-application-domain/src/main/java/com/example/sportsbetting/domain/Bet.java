/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sanyi
 */
@Entity
public class Bet implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bet() {
    }

    public Bet(String description, SportEvent event, List<Outcome> winnerOutcomes, BetType type) {
        this.setDescription(description);
        this.setEvent(event);
        this.setWinnerOutcome(winnerOutcomes);
        this.setBettype(type);
    }

    @Column("description")
    private String description;
     
    @OneToOne
    private SportEvent event;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<Outcome> winnerOutcomes;
    
    @Enumerated(EnumType.STRING)
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
