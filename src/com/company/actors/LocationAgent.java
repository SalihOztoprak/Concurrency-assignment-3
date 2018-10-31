package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;

public class LocationAgent extends AbstractLoggingActor {
    private String city;
    private int availableRooms;

    public LocationAgent(String city, int availableRooms) {
        this.city = city;
        this.availableRooms = availableRooms;
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
