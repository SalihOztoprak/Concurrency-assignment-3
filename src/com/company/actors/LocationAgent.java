package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import com.company.message.RequestLocations;
import com.company.message.ResponseLocations;

import java.util.Random;

public class LocationAgent extends AbstractLoggingActor {
    private String city;
    private int availableRooms;

    public LocationAgent(String city) {
        this.city = city;
        availableRooms = new Random().nextInt(20) + 5;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestLocations.class, message -> {

                })
                .build();
    }
}
