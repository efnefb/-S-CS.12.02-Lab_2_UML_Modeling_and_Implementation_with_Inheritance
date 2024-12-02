package org.example;

public class PremiumPassenger extends Passenger{
    private static double discountFactor = 0.1;
    public PremiumPassenger(String name, int passengerNum, double balance){
        super(name, passengerNum, balance);
    }

    //Overrided the cost deduction policy
    public double deductedBalance(double initBalance, double cost){
        return initBalance - discountFactor * cost;
    }

    @Override
    public String toString() {
        return "PremiumPassenger{" +
                "name='" + super.getName() + '\'' +
                ", passengerNum=" + super.getPassengerNum() +
                ", balance= " + super.getBalance() +
                ", activities= " + super.getActivities().toString() + "}";
    }

}
