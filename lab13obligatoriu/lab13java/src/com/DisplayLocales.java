package com;

import java.util.Locale;

public class DisplayLocales {
    public static void getLocale(){
        System.out.println("Available locales:");
        Locale available[] =
                Locale.getAvailableLocales();
        for(Locale locale : available) {
            System.out.println("Country:  " +locale.getDisplayCountry() + "  " + "----> Language:  "+
                    locale.getDisplayLanguage(locale));
        }
    }
    public void getDefaultLocale() {
        System.out.println( "Default Locale = " + Locale.getDefault() );
    }

}
