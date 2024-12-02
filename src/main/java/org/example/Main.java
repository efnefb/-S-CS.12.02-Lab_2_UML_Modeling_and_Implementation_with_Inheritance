package org.example;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        //Set up
        CruiseShip ship = new CruiseShip("Ship", 100);

        //Create destinations
        Destination dest1 = new Destination("dest1");
        Destination dest2 = new Destination("dest2");
        Destination dest3 = new Destination("dest3");

        //Create activities --> Add to dest1
        Walk walk_d1 = new Walk("walk_d1", "a very long walk", 500, 3, 2_000_000_000);
        Activity visit = new Visit("visit", "a visit", 600, 3);
        dest1.addActivity(walk_d1);
        dest1.addActivity(visit);

        //Create activities --> Add to dest2
        Show show_d2 = new Show(
                "show_d2", "a nice show", 1_000_000, 5, new ArrayList<>(Arrays.asList("Actor:Bob; Role:Jimmy", "Actor:Steven; Role:Tim"))
        );
        dest2.addActivity(show_d2);

        //Create activities --> Add to dest3
        Walk walk_d3 = new Walk("walk_d3", "a good walk", 500, 3, 1_000_000);
        Show show_d3 = new Show(
                "show_d3", "a show where you show things", 2_000_000, 6, new ArrayList<>(Arrays.asList("Actor:John; Role:James", "Actor:Robert; Role:Bill"))
        );
        dest3.addActivity(walk_d3);
        dest3.addActivity(show_d3);

        //Add destinations to ship
        ship.addDest(dest1);
        ship.addDest(dest2);
        ship.addDest(dest3);

        //Create passengers --> Add to ship
        StandardPassenger pass1 = new StandardPassenger("pass1", 1, 1_000);
        PremiumPassenger pass2 = new PremiumPassenger("pass2", 2, 1_000);
        SeniorPassenger pass3 = new SeniorPassenger("pass3", 3, 1_000);
        ship.addPassenger(pass1);
        ship.addPassenger(pass2);
        ship.addPassenger(pass3);


        //Initial displays
        System.out.println("(Set up scenario)\n");
        System.out.println("First look at the initial situation:\n");
        System.out.println("1) Ship itinerary:");

        ship.showItinerary();

        System.out.println("\n");
        System.out.println("2) Passenger list:");

        ship.showPassengerList();

        System.out.println("\n");
        System.out.println("3) Available activities:");

        ship.showAvailableActivities();

        System.out.println("\n\n\n");
        System.out.println("----------");


        //Scenario 1:
        System.out.println("Scenario 1:\nAdd walk_d1 to dest2, then look at dest2's activities list:\n");


        dest2.addActivity(walk_d1);


        System.out.println(dest2.getActivities().toString()); //walk_d1 not shown because walk_d1 already in dest1
        System.out.print("\n");
        System.out.println("==> Walk_d1 is not shown, because walk_d1 is already in dest1 --> same activity can't be in two locations.");
        System.out.println("To illustrate further, create a new activity, walk_d2, and add to dest2. Then look at dest2's activities:\n");


        Walk walk_d2 = new Walk("walk_d2", "a walk where you walk to places", 1, 2, 3);
        dest2.addActivity(walk_d2);


        System.out.println(dest2.getActivities().toString()); //To illustrate: walk_d2 not assigned to any dest yet, so is shown.
        System.out.print("\n");
        System.out.println("As can be seen, walk_d2 is added to dest2, since walk_d2 has not yet been assigned to any destination yet.\n");
        System.out.println("We can remove activities as well. Remove walk_d2 from dest2, then see dest2's activities:\n");


        dest2.removeActivity(walk_d2);


        System.out.println(dest2.getActivities().toString()); //Can also remove activities
        System.out.println("As can be seen, walk_d2 no longer there.");
        System.out.println("----------");
        System.out.println("\n\n\n");
        System.out.println("----------");


        //Scenario 2:
        //Illustrate balances change + activities list change
        System.out.println("Scenario 2:\n Signing up for activities.\n");
        System.out.println("1) Sign up pass1 for --> walk_d1, walk_d3:\n");
        System.out.println("Before sign-up:\n");
        System.out.println(pass1);


        pass1.signUp(walk_d1);
        pass1.signUp(walk_d3);


        System.out.println("\nAfter sign-up:\n");
        System.out.println(pass1);
        System.out.println("\n");
        System.out.println("Note that i) The activities bought are reflected in pass1's toString() representation; ii) The cost deduction policy is correctly implemented (pass1 is a StandardPassenger)");
        System.out.print("\n");

        System.out.println("2) Sign up pass2 for --> show_d2, walk_d3:\n");
        System.out.println("Before sign-up:\n");
        System.out.println(pass2);
        System.out.print("\n");


        pass2.signUp(show_d2);
        pass2.signUp(walk_d3);


        System.out.println("After sign-up:\n");
        System.out.println(pass2); //Note that because balance not enough, order for show_d2 rejecetd
        System.out.println("Notice that as a PremiumPassenger, pass2's cost deduction policy is different than pass2 (only 10% of 500 i.e. 50 is deducted).");
        System.out.println("Also notice that since show_d2's cost is out of pass2's budget, pass2 can only buy walk_d3, and the order for show_d2 is rejected.");
        System.out.println("\n");

        System.out.println("3) Sign up pass3 for --> walk_d1, visit:\n");
        System.out.println("Before sign-up:\n");
        System.out.println(pass3);
        System.out.print("\n");


        pass3.signUp(walk_d1);
        pass3.signUp(visit);


        System.out.println("After sign-up:\n");
        System.out.println(pass3);
        System.out.print("\n");
        System.out.println("Notice that since pass3 is a SeniorPassenger, no cost was deducted from balance.\n\n");

        System.out.println("If we look at walk_d1, we can see that spots_available=1, whereas its capacity is 3. We signed up pass1 and pass3 for walk_d1, so it makes sense that only 1 spot is left:\n");
        //Illustrate passengers spots filled
        System.out.println(walk_d1);
        System.out.println("\nFurthermore, If we look at walk_d1's list of passengers, we see that it correctly reflects the sign-ups we have just done (only pass1 and pass3 are in the list):\n");
        System.out.println(walk_d1.getPassengers().toString());
        System.out.println("----------");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("----------");
        System.out.println("Scenario 3:");
        System.out.println("Sign up pass1 for visit (which is at dest1) then look at pass1's activities list:\n");


        pass1.signUp(visit);


        System.out.println(pass1.getActivities().toString()); //Not signed up because already signed up for walk_d1 at dest1
        System.out.println("\nAs can be seen, the sign up failed because pass1 is already signed up for an activity at dest1 (walk1) --> can't sign up for more than one activity at a single dest.");
        System.out.println("----------");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");

        System.out.println("----------");
        System.out.println("Scenario 4:");
        System.out.println("\nSign up pass2 for walk_d1.");
        System.out.println("\nCreate a new passenger and sign that passenger up for walk_d1, then look at that passenger's list of activities:");

        pass2.signUp(walk_d1);
        StandardPassenger extra_passenger = new StandardPassenger("ExtraPersonThatNobodyWants", 4, 1000);
        extra_passenger.signUp(walk_d1);


        System.out.print("\n");
        System.out.println(extra_passenger.getActivities().toString()); //empty --> not signed up
        System.out.println("\nIt is empty --> the extra passenger was not signed up, because walk_d1 had already reached its max capacity of 3 people.\n");
        System.out.println("If we look at walk_d1's passenger list, we see that it has three passengers, pass1, pass2, and pass3, and is at its max capacity:\n");
        System.out.println(walk_d1.getPassengers().toString()); //3 passengers --> capacity limit
        System.out.println("----------");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");


        System.out.println("Look at the situation after the scenarios:\n");
        System.out.println("1) Ship itinerary:");
        ship.showItinerary();
        System.out.println("\n");
        System.out.println("2) Passenger list:");
        ship.showPassengerList();
        System.out.println("\n");
        System.out.println("3) Available activities:");
        ship.showAvailableActivities();
        System.out.println("\n\n\n");
    }


}