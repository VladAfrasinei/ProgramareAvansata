package com;

import java.util.Arrays;
import java.util.Objects;

public class Depot {
    String name;
    Vehicle vehicles[];
    public Depot(){
        this.name=null;
    }
    public Depot(String name)
    {
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + Arrays.toString(vehicles) +
                '}';
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle... vehicles) {
        //this.vehicles = vehicles; Nu putem lasa doar aceasta functie deoare un depozit nu accepta dubluri
        int ok=1;
        for(Vehicle i : vehicles)
        {
            ok=1;
            if(this.vehicles!=null)//In cazul in care n aveam vehicle e clar ca nu putem avea dulburi si trebuie adaugate direct
                for(Vehicle j : this.vehicles)
                    if(i.equals(j))
                        ok=0;//Inseamna ca avem deja acest vehicul si nu mai trebuie adaugat

        }
        if (ok == 1)
            this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(vehicles);
        return result;
    }
}
