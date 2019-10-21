/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.Player;
import java.math.BigDecimal;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sanyi
 */
public interface IPlayerDao {
    
    @Transactional
    public void AddPlayer(Player player);
    
    @Transactional
    void UpdatePlayerBalance(BigDecimal newVal);
    
    public Player GetActualPlayer();
}
