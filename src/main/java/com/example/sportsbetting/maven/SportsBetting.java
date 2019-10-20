/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.maven;

import com.example.sportsbetting.app.App;
import com.epam.training.sportsbetting.config.AppConfig;
import com.example.sportsbetting.language.LanguageService;
import java.text.MessageFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        Logger logger = LoggerFactory.getLogger(SportsBetting.class);

        String language;
        String country;
        if (args.length != 2) {
            language = "en";
            country = "US";
        } else {
            language = args[0];
            country = args[1];
        }
        MessageFormat formatter = new MessageFormat("Set locatization to {0} {1}");
        logger.info(formatter.format(new Object[]{language, country}));
        LanguageService.setLocale(language, country);
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App application = context.getBean((App.class));
            application.play();
        }

    }

}
