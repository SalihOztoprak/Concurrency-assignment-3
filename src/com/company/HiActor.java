package com.company;

import akka.actor.AbstractActor;

public class HiActor extends AbstractActor {
    @Override
    public void preStart() {
        System.out.println("Hi actor started");
    }

    public void postStop() {
        System.out.println("Hi actor exiting");
    }

    public Receive createReceive() {
        return receiveBuilder()
                .match(Message.class, greeting -> {
                    switch (greeting) {
                        case CANIRENT:
                            System.out.println("Is there a room available?");
                            break;
                        case AVAILABLE:
                            System.out.println("There is a room available");
                            break;
                        case UNAVAILABLE:
                            System.out.println("There are no rooms available");
                            break;
                        case RENTED:
                            System.out.println("I would like to rent it ");
                            break;
                        default:
                            System.out.println("Sorry I dont get it, please try again! ");
                    }
                })
                .match(String.class, System.out::println).build();
    }
}