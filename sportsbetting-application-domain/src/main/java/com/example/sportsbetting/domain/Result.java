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
public class Result {

    public Result(List<Outcome> winnerOutcomes) {
       this.setWinnerOutcomes(winnerOutcomes);
    }


    private List<Outcome> winnerOutcomes;

    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }

    public void setWinnerOutcomes(List<Outcome> outcome) {
        this.winnerOutcomes = outcome;
    }
}
