package org.example;

public class Walk extends Activity{
    private int distance;
    public Walk(String name, String description, int cost, int capacity, int dist){
        super(name, description, cost, capacity);
        this.distance = dist;
    }

    @Override
    public String toString() {
        return "Walk{"+
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", cost=" + super.getCost() +
                ", capacity=" + super.getCapacity() +
                ", location=" + super.getLocation().getName() +
                ", spots_available= " + spots_available() +
                ", distance= " + distance + "}";
    }
}