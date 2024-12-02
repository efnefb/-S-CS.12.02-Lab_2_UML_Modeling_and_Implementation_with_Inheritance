package org.example;

public class Visit extends Activity{
    public Visit(String name, String description, int cost, int capacity){
        super(name, description, cost, capacity);
    }

    @Override
    public String toString() {
        return "Visit{"+
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", cost=" + super.getCost() +
                ", capacity=" + super.getCapacity() +
                ", location=" + super.getLocation().getName() +
                ", spots_available= " + spots_available() + "}";
    }
}