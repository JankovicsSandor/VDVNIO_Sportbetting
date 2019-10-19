/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.sportsbetting.config;

import com.example.sportsbetting.service.SportBettingSerivce;
import com.example.sportsbetting.view.View;
import com.example.sportsbetting.app.App;
import com.example.sportsbetting.database.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author Sanyi
 */


@Configuration
public class AppConfig {
    @Bean
    public App getApp(){
        return new App(this.getService(),this.getView());
    }
    
    @Bean
    public SportBettingSerivce getService(){
        return new SportBettingSerivce(this.getDatabase());
    }
    
    @Bean
    public Database getDatabase(){
        return new Database();
    }
    
    @Bean
    public View getView(){
        return new View();
    }
}
