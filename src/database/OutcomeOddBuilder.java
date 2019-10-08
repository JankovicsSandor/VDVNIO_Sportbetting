/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Outcome;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Sanyi
 */
public class OutcomeOddBuilder {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public Outcome getOutcome() {
        return outcome;
    }
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private Outcome outcome;

    public OutcomeOddBuilder value(BigDecimal value) {
        this.value = value;
        return this;
    }

    public OutcomeOddBuilder validFrom(LocalDateTime date) {
        this.validFrom = date;
        return this;
    }

    public OutcomeOddBuilder validUntil(LocalDateTime date) {
        this.validUntil = date;
        return this;
    }

    public OutcomeOddBuilder outcome(Outcome outcome) {
        this.outcome = outcome;
        return this;
    }

}
