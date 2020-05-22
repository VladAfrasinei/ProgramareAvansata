package com;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    List<Client> clients = new ArrayList<Client>(); //Cream o lista de clienti
    List<Depot> depots = new ArrayList<Depot>();//Cream o lista de depot
    //Dupa cum stim nu avem voie sa adaugam acelasi depot sau acelasi client de 2 ori asa ca va trebui sa rezolvam aceasta problema

    //Asa facem sa adaugam cate un client unic(adica fiecare client maxim o data)
    public void addClient(Client... client1)//Asta inseamna ca 0 sau mai multe obiecte de tip client vor fi transmise ca parametru
    {
        int ok=1;
        for(Client i : client1)
        {
            ok=1;//Va trebui sa facem aceasta initializare aici pt a verifica fiecare client
            for(Client j : clients)
                if(i.equals(j))
                    ok=0;
                if(ok==1)//Daca n am gasit niciun client la fel il adaugam
                    clients.add(i);
        }
    }
    //Acum va trebui sa facem aceeasi verificare ca la clients. Este fix acelasi cod ca mai sus doar ca schimbam tipul
    public void addDepot(Depot... depot1)
    {
        int ok=1;
        for(Depot i : depot1)
        {
            ok=1;
            for(Depot j : depots)
                if(i.equals(j))
                    ok=0;
                if(ok==1)
                    depots.add(i);
        }
    }

    @Override
    public String toString() {
        return "Problem{" +
                "clients=" + clients +
                ", depots=" + depots +
                '}';
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Depot> getDepots() {
        return depots;
    }
    //Vom avea nevoie si de o functie care sa preia toate vehicule din toate depots.
    public  List<Vehicle> getVehicles()
    {
        List<Vehicle> vehicles=new ArrayList<Vehicle>();//Aici vom adauga toate vehiculele
        for(Depot i : depots)
            for(Vehicle j : i.getVehicles()) //Pentru fiecare depot i in parte vom lua viecare vehicle j cu functia getVehicles.
                vehicles.add(j);
            return vehicles;
    }
}
