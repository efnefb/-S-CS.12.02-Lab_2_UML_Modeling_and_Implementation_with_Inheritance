package org.example;

import java.util.ArrayList;
public class Destination {
    private String name;
    private ArrayList<Activity> activities;

    public Destination(String name) {
        this.name = name;
        activities = new ArrayList<>();
    }

    public String getName(){return name;}
    public void setName(String newName) {name=newName;}
    public ArrayList<Activity> getActivities(){return this.activities;}

    public void addActivity(Activity activity){ //add an activity to destination
        if (activity.getLocation() == null && !activities.contains(activity)) {
            activity.setLocation(this);
            activities.add(activity);
        }
    }

    public void removeActivity(Activity activity){ // remove an activity from destination
        activity.setLocation(null);
        activities.remove(activity);
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", activities=" + activities +
                '}';
    }
}
