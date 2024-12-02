package org.example;

import java.util.ArrayList;
public class Passenger {
    private String name;
    private int passengerNum;
    private ArrayList<Activity> activities;
    private double balance;

    public Passenger(String name, int passengerNum, double balance) {
        this.name = name;
        this.passengerNum = passengerNum;
        this.balance = balance;
        activities = new ArrayList<>();
    }

    public String getName(){return name;}
    public void setName(String newName){name = newName;}
    public int getPassengerNum() {return passengerNum;}
    public void setPassengerNum(int newPassengerNum){passengerNum = newPassengerNum;}
    public double getBalance(){
        return balance;
    }

    public ArrayList<Activity> getActivities(){
        return activities;
    }

    public void signUp(Activity activity){ //Sign up for an activity
        if (deductedBalance(balance, activity.getCost()) >= 0) {
            if (!hasDest(activity) && activity.getLocation() != null && activity.belowMaxCapacity()
                    &&(activity.getPassengers()==null || !activity.getPassengers().contains(this))){
                activities.add(activity);
                activity.addPassenger(this);
                balance = deductedBalance(balance, activity.getCost());
            }
        }
    }

    public boolean hasDest(Activity activity){ //Helper for: If passenger already signed up for an activity at the dest --> do nothing
        for (Activity act: activities){
            if (act.getLocation().equals(activity.getLocation())) return true;
        }
        return false;
    }

    public double deductedBalance(double initBalance, double cost){
        return initBalance - cost;
    } //Cost deduction policy


    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passengerNum=" + passengerNum +
                ", balance= " + balance +
                ", activities= " + activities.toString() + "}";
    }
}

