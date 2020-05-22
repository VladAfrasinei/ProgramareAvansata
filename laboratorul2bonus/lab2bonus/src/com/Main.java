package com;

public class Main {

    public static void main(String[] args) {
        Problem pb = new Problem();
        Client c1 = new Client();
        c1.setName("Client 1");
        c1.setNr(1);

        Client c2 = new Client("Client 2", 1);
        Client c3 = new Client("Client 3", 2);
        Client c4 = new Client("Client 4", 3);

        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("V1");
        vehicles[1] = new Drone("V2");
        vehicles[2] = new Truck("V3");
        Depot d1 = new Depot("Depot 1");
        d1.setVehicles(vehicles[0], vehicles[1]);
        Depot d2 = new Depot("Depot 2");
        Depot d3 = new Depot("Depot 2");
        d2.setVehicles(vehicles[2]);
        pb.addClient(c1, c2, c3, c4);
        pb.addDepot(d1, d2, d3);
        System.out.println(pb);
        int graph[][] = new int[][]{{-1, -1, 2, -1, -1},
                {-1, -1, -1, 5, -1},
                {-1,  1, -1, 2, 3},
                {-1, -1, -1, -1, 3},
                {-1, -1, 4, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, 3, -1},
                {-1, -1, -1, -1, 2},
                {-1, -1, -1, -1, -1}};
        Solution p = new Solution(5);//Setam numarul matricii din constructor
        p.BellmanFord(graph, 0);//Apelam algoritmul
    }
}

