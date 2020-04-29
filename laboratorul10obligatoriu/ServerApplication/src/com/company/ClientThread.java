package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {

    private Socket socket = null ;
    private ServerSocket serverSocket=null;
    //A trebuit sa trimit si serverSocket din constructor deoarece la stop ne cere sa inchidem tot server-ul nu doar conexiunea si in clientThread nu am avut acces la serversocket ca sa pot da close.
    public ClientThread (Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket=serverSocket;
    }
    public void run () {
        try {
            //Avand in vedere ca pot fi mai multe comenzi este necesar un while
            while(true) {
                // Aici se obtine comanda de la client
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                //Va trebui sa vedem daca server-ul primeste comanda stop si in acest caz sa returnam server stopped si in caz contrar daca nu primeste comanda stop sa returnam server received the request.
                if(request.equals("stop")) {
                    String raspuns ="Server stopped";
                    out.println(raspuns);
                    out.flush();
                    //Va trebui sa iesim din while in acest caz si o putem face cu un break
                    serverSocket.close();
                }
                else
                {
                    String raspuns="Server received the request";
                    out.println(raspuns);
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}