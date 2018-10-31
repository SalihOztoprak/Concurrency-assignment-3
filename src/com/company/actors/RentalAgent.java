package com.company.actors;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.Map;

public class RentalAgent extends AbstractLoggingActor {
    private Map<String, ActorRef> actorRefMap;

    private RentalAgent(Map<String, ActorRef> actorRefMap) {
        this.actorRefMap = actorRefMap;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();

        actorRefMap.put("Enschede", getContext().getSystem().actorOf(Props.create(LocationAgent.class), "Enschede"));
        actorRefMap.put("Amsterdam", getContext().getSystem().actorOf(Props.create(LocationAgent.class), "Amsterdam"));
        actorRefMap.put("Deventer", getContext().getSystem().actorOf(Props.create(LocationAgent.class), "Deventer"));
        actorRefMap.put("Almelo", getContext().getSystem().actorOf(Props.create(LocationAgent.class), "Almelo"));
        actorRefMap.put("Goor", getContext().getSystem().actorOf(Props.create(LocationAgent.class), "Goor"));
    }

    public static Props prop(ActorRef partner) {
        return Props.create(LocationAgent.class, partner);
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
