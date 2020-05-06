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
    public int linie;
    public int coloana;
    Board boardgame;
    //A trebuit sa trimit si serverSocket din constructor deoarece la stop ne cere sa inchidem tot server-ul nu doar conexiunea si in clientThread nu am avut acces la serversocket ca sa pot da close.
    public ClientThread (Socket socket, ServerSocket serverSocket,Board boardgame) {
        this.socket = socket;
        this.serverSocket=serverSocket;
        this.boardgame=boardgame;
    }

    public ClientThread(Socket socket, ServerSocket serverSocket) {
    }

    public void setlinie(int x)
    {
        this.linie=x;
    }
    public void setcoloana(int x)
    {
        this.coloana=x;
    }

    public int getColoana() {
        return coloana;
    }

    public int getLinie() {
        return linie;
    }
    public ClientThread() {

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
                {   //S a ales o mutare
                    //impartim comanda in 2 pentru a prelua cele 2 valori
                    String []parts=request.split(" ");
                    String part1=parts[0];
                    String part2=parts[1];
                    int a;
                    a=Integer.parseInt(part1);
                    setlinie(a);
                    a=Integer.parseInt(part2);
                    setcoloana(a);
                    String raspuns = null;
                    for(int i=0;i<100;i++) {
                        for (int j = 0; j < 100; j++) {
                            raspuns = Integer.toString(boardgame.matrice[i][j]);
                            raspuns = raspuns + " ";
                        }
                        raspuns = raspuns + '\n';
                    }
                    //Trimitem matricea ca string la client pentru a vedea pozitiile libere pe care sa le aleaga.
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