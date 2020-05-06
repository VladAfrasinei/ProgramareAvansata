package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GameClient {

    public GameClient () throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try {
                Socket socket = new Socket(serverAddress, PORT);
                while(true) {
                    Scanner read=new Scanner(System.in);
                    System.out.println("Va rugam sa dati o comanda de tipul stop, exit sau 2 numere cu spatiu intre ele care sa reprezinte linia si coloana!");
                    //Vom da mutarea pe care o va face player-ul.
                    System.out.println("Dati comanda:");
                    String comanda=read.next();
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream()));
                out.println(comanda);
            // In acest caz se opreste clientul
                    if(comanda.equals("exit"))
                        break;
                    // trimite comanda catre server

            String raspuns=in.readLine();
            System.out.println(raspuns);
            //Aceasta comanda este in cazul in care dam stop din client si se inchide server-ul sa primim si mesajul cu server stopped de asta a fost pusa dupa system.out.println cat si sa nu ne mai lase sa dam o noua comanda.
            if(comanda.equals("stop"))
                break;}
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
