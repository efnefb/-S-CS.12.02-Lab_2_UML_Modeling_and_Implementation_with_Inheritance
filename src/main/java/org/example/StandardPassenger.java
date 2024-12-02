package org.example;

public class StandardPassenger extends Passenger{
    public StandardPassenger(String name, int passengerNum, int balance){
        super(name, passengerNum, balance);
    }
    @Override
    public String toString() {
        return "StandardPassenger{" +
                "name='" + super.getName() + '\'' +
                ", passengerNum=" + super.getPassengerNum() +
                ", balance= " + super.getBalance() +
                ", activities= " + super.getActivities().toString() + "}";
    }
}