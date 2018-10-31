package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Tenant extends AbstractLoggingActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Object.class, (Object msg) -> {
            if (msg instanceof CustomerService) {
                System.out.println("Reactie ontvangen");
            }
        }).build();
    }
}
