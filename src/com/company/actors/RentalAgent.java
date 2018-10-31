package com.company.actors;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.company.message.RequestLocations;

import java.util.HashMap;

public class RentalAgent extends AbstractLoggingActor {
    private HashMap<String, ActorRef> actorRefMap;

    private RentalAgent(HashMap<String, ActorRef> actorRefMap) {
        this.actorRefMap = actorRefMap;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();

    }

    public static Props prop(HashMap<String, ActorRef> map) {
        return Props.create(RentalAgent.class, map);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestLocations.class, message -> {
                    log().info("Received message: " + message);
                })
                .build();
    }
}
