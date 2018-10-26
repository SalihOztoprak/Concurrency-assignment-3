package com.company;

import akka.actor.AbstractActor;
import com.company.HiActor;

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
                        case HELLO:
                            System.out.println("Hello too");
                            break;
                        case NO_GREETING:
                            System.out.println("HI");
                            break;
                        case INSULT:
                            System.out.println("Thank You");
                            break;
                        default:
                            System.out.println("Sorry ? ");
                    }
                })
                .match(String.class, System.out::println).build();
    }
}