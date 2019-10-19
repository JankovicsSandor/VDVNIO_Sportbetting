/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sportsbetting.language;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Sanyi
 */
public class LanguageService {

    private static Locale locale;

    public static ResourceBundle getLocaleBundle() {
        return ResourceBundle.getBundle("messages",locale);
    }

    public static void setLocale(String language, String country) {
        LanguageService.locale = new Locale(language, country);
    }

}
