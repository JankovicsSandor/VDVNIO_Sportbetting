/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.maven;
import com.example.sportsbetting.app.App;
import com.epam.training.sportsbetting.config.AppConfig;
import com.example.sportsbetting.language.LanguageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Sanyi
 */
public class SportsBetting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String language="";
        String country;
        if(args.length !=2){
            language="en";
            country = "US";
        }else{
            language=args[0];
            country=args[1];
        }        
        LanguageService.setLocale(language, country);      
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App application = context.getBean((App.class));
            application.play();
        }

    }

}
