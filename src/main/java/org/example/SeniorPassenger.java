package org.example;

public class SeniorPassenger extends Passenger{
    private static double discountFactor = 0;
    public SeniorPassenger(String name, int passengerNum, double balance){
        super(name, passengerNum, balance);
    }
    //Overrided cost deduction policy
    public double deductedBalance(double initBalance, double cost){
        return initBalance - discountFactor * cost;
    }
    @Override
    public String toString() {
        return "SeniorPassenger{" +
                "name='" + super.getName() + '\'' +
                ", passengerNum=" + super.getPassengerNum() +
                ", balance= " + super.getBalance() +
                ", activities= " + super.getActivities().toString() + "}";

    }
}
