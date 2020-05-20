package app;
import com.*;
import com.Info;
import com.SetLocale;
import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {

    public static void main(String args[]) {
        int ruleaza=1;
        Scanner consola = new Scanner(System.in);
        Locale locale;
        while(ruleaza!=0)
        {
            System.out.println("Alegeti o comanda:");
            System.out.println("Display Locales");
            System.out.println("Set locales");
            System.out.println("Information");
            System.out.println("Stop");
            String citire=consola.nextLine();
            if(citire.equals("Information"))
            {
                System.out.println("Alegeti un tag al tarii(ro,en,etc)");
                String tag=consola.nextLine();
                Locale locale1=new Locale(tag.toLowerCase(),tag.toUpperCase());
                SetLocale.SetLocale(locale1);
                System.out.println("Informatii despre localizare sunt");
                Info.displayinformation(locale1);
            }
            else
                if(citire.equals("Set locales"))
                {
                    System.out.println("Choose a locale:");
                    String localecit=consola.nextLine();
                    Locale localecit1=new Locale(localecit);
                    SetLocale setlocale1=new SetLocale();
                    setlocale1.SetLocale(localecit1);
                }
                else
                    if(citire.equals("Display Locales"))
                        DisplayLocales.getLocale();
                    else
                    {
                        ruleaza=0;
                        break;
                    }

        }

    }
}
