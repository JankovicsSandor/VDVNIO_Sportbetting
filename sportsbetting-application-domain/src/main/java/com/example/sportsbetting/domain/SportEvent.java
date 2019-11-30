/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sanyi
 */
@Entity
@Inheritance
public abstract class SportEvent implements Serializable {

    @Id
    @GeneratedValue
    private int Id;

    @Column(name = "title")
    private String title;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate", columnDefinition = "TIME")
    private LocalDateTime endDate;

    @OneToMany(targetEntity = Bet.class, fetch = FetchType.EAGER)
    private Set<Bet> bets;

    @OneToOne(fetch = FetchType.EAGER)
    private Result result;

    public SportEvent() {
    }

    public SportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, Set<Bet> bets, Result result) {
        this.setTitle(title);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setBets(bets);
        this.setResult(result);
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Set<Bet> getBets() {
        return bets;
    }

    public void setBets(Set<Bet> bets) {
        for (Bet bet1 : bets) {
            bet1.setEvent(this);
        }
        this.bets = bets;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
