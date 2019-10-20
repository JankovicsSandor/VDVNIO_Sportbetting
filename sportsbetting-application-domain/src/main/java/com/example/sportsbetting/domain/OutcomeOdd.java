/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Sanyi
 */

@Entity
public class OutcomeOdd implements Serializable {
    
    @Id
    @GeneratedValue
    private int Id;

    public OutcomeOdd() {
    }

    public OutcomeOdd(BigDecimal value, LocalDateTime validFrom, LocalDateTime validUntil, Outcome outcome) {
        this.setValue(value);
        this.setValidFrom(validFrom);
        this.setValidUntil(validUntil);
        this.setOutcome(outcome);
    }

    @Column(name="value")
    private BigDecimal value;
    
    @Column(name="validFrom")
    private LocalDateTime validFrom;
    
    @Column(name="validUntil")
    private LocalDateTime validUntil;
    
    @OneToOne()
    private Outcome outcome;

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }
}
