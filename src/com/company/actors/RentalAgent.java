package com.company.actors;

import akka.actor.ActorRef;
import akka.actor.Props;

public class RentalAgent extends Person {
    private ActorRef locationAgent;

    private RentalAgent(ActorRef partner) {
        locationAgent = partner;
    }

    public static Props prop(ActorRef partner){
        return Props.create(LocationAgent.class,partner);
    }

    @Override
    public Receive createReceive() {
        return super.createReceive();
    }
}
