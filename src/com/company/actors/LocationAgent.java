package com.company.actors;

import akka.actor.AbstractLoggingActor;
import com.company.message.RequestRooms;
import com.company.message.ResponseRooms;

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
                .match(RequestRooms.class, message -> {
                    getSender().tell(new ResponseRooms(message.getSender(), availableRooms, message.getRequestedRooms()),getSelf());
                })
                .build();
    }
}
