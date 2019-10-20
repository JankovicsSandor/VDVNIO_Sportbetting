/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Sanyi
 */

@Entity
public class Result implements Serializable {
    
    @Id
    @GeneratedValue
    private int Id;
    
   @ManyToOne()
    private List<Outcome> winnerOutcomes;

    public Result() {
    }

    public int getId() {
        return Id;
    }

    public Result(List<Outcome> winnerOutcomes) {
       this.setWinnerOutcomes(winnerOutcomes);
    }

    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }

    public void setWinnerOutcomes(List<Outcome> outcome) {
        this.winnerOutcomes = outcome;
    }
}
