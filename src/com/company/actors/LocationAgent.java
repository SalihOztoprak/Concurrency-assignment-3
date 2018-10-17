package com.company.actors;

import com.company.Message;

public class LocationAgent extends Person {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Message.class, message -> {
                    System.out.println("Received String message: {}" + message);
                }).matchAny(o -> System.out.println("received unknown message"))
                .build();
    }
}
