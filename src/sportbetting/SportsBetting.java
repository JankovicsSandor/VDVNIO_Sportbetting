/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportbetting;

import com.epam.training.sportsbetting.config.AppConfig;
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
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            App application = context.getBean((App.class));
            application.play();
        }

    }

}
