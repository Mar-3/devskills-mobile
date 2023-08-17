package org.mar_3.webdev_mobile_project;

public class Participant {

    String name;
    String avec;
    String friend;

    // Constructor for a new participant
    public Participant(String n, String a, String f) {
        this.name = n;
        this.avec = a;
        this.friend = f;
    }


    public String getName() {
        return this.name;
    }

}
