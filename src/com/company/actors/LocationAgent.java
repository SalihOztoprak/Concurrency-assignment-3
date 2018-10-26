package com.company.actors;

import com.company.Message;

public class LocationAgent extends Person {
    private String city;
    private int availableRooms;

    public LocationAgent(String name, String city, int availableRooms) {
        super(name);
        this.city = city;
        this.availableRooms = availableRooms;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Message.class, message -> {
                    System.out.println("Received String message: {}" + message);
                }).matchAny(o -> System.out.println("received unknown message"))
                .build();
    }
}
