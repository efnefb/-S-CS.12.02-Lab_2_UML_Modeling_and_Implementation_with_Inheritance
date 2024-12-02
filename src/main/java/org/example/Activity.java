package org.example;

import java.util.ArrayList;
public class Activity {
    private String name;
    private String description;
    private int cost;
    private int capacity;
    private Destination location;
    private ArrayList<Passenger> passengers;

    public Activity(String name, String description, int cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Destination getLocation() {
        return location;
    }

    public void setLocation(Destination location) {
        this.location = location;
    }

    public int getCost(){
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public boolean belowMaxCapacity(){ //Check if activity is below max capacity
        if (passengers!=null) return passengers.size() < capacity;
        else return true;
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
    public int spots_available(){ //Get the number of spots left
        if (passengers!=null){
            return capacity - passengers.size();
        } else{
            return capacity;
        }
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", capacity=" + capacity +
                ", location=" + location.getName() +
                ", spots_available= " + spots_available() +
                "}";
    }
}


