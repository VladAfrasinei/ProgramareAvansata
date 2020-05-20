package com;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        SetLocale setlocale=new SetLocale();
        Locale currentLocale = Locale.getDefault();
        Locale roLocale=new Locale("ro","RO");
        Info info=new Info();
        info.displayinformation(roLocale);
    }
}
