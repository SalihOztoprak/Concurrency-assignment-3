package com.company.actors;

import akka.actor.ActorRef;
import com.company.message.Message;

public class LocationAgent extends Person {
    private String city;
    private int availableRooms;
    private ActorRef ref;



    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Message.class, message -> {
                    System.out.println("Received String message: {}" + message);
                }).matchAny(o -> System.out.println("received unknown message"))
                .build();
    }

    public ActorRef getRef() {
        return ref;
    }
}
