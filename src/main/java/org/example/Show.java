package org.example;

import java.util.ArrayList;
public class Show extends Activity{
    private ArrayList<String> stars;
    public Show(String name, String description, int cost, int capacity, ArrayList<String> stars){
        super(name, description, cost, capacity);
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Show{"+
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", cost=" + super.getCost() +
                ", capacity=" + super.getCapacity() +
                ", location=" + super.getLocation().getName() +
                ", spots_available= " + spots_available() +
                ", stars= " + stars.toString() + "}";
    }
}
