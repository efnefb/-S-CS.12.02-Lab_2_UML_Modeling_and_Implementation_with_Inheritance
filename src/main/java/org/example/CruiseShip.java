package org.example;

import java.util.ArrayList;
public class CruiseShip {
    private String name;
    private int capacity;
    private ArrayList<Destination> itinerary;
    private ArrayList<Passenger> passengers;

    public CruiseShip(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        itinerary = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    public String getName(){return name;}
    public void setName(String newName){name = newName;}
    public int getCapacity(){return capacity;}
    public void setCapacity(int newCapacity){capacity = newCapacity;}
    public ArrayList<Passenger> getPassengers(){return passengers;}
    public ArrayList<Destination> getItinerary() {return itinerary;}


    //Add and remove destinations and passengers
    public void addDest(Destination dest){
        if (!itinerary.contains(dest)) itinerary.add(dest);
    }
    public void removeDest(Destination dest){
        itinerary.remove(dest);
    }
    public void addPassenger(Passenger passenger){
        if (passengers.size() < capacity) this.passengers.add(passenger);
    }
    public void removePassenger(Passenger passenger){
        passengers.remove(passenger);
    }



    //Printing information methods
    public void showItinerary(){
        System.out.println("Ship_name= " + name + "\nDestinations:");
        for (Destination dest: itinerary){
            System.out.println("\tDest_name= " + dest.getName() + "\n\tActivities:");
            for (Activity act: dest.getActivities()){
                System.out.println("\t\t" + act.toString());
            }
        }
    }

    public void showPassengerList(){
        System.out.println("Ship_name= " + name);
        System.out.println("Capacity= " + capacity);
        System.out.println("Num_passengers= " + passengers.size() + "\nPassengers:");
        for (Passenger passenger: passengers){
            System.out.print("passenger_name= " + passenger.getName());
            System.out.println(", passenger_num= " + passenger.getPassengerNum());
        }
    }

    public void showAvailableActivities(){
        System.out.println("Still available activities:");
        for (Destination dest: itinerary){
            for (Activity act: dest.getActivities()){
                if (act.belowMaxCapacity()) System.out.println(act);
            }
        }
    }
}