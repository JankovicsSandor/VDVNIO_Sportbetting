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
public class Result {
    private List<Outcome> innerOutcomes;

    public List<Outcome> getinnerOutcomes() {
        return innerOutcomes;
    }

    public void setinnerOutcomes(List<Outcome> outcome) {
        this.innerOutcomes = outcome;
    }
}
