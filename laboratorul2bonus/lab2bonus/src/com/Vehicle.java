package com;

import java.util.Objects;

public class Vehicle {
    String name;
    String type;
    Depot depot;

    public Vehicle() {
    }

    public Vehicle(String name) {
        this.name = name;
        this.depot = null;
        this.type = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Depot getDepot() {
        return depot;
    }

    public String getType() {
        return type;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", depot=" + depot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(name, vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, depot);
    }
}
