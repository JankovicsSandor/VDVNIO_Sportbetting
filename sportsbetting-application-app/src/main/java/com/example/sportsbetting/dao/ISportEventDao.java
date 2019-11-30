/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.SportEvent;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sanyi
 */
public interface ISportEventDao {

    @Transactional
    public void save(SportEvent event);

    public List<SportEvent> GetAllSportEvents();
}
