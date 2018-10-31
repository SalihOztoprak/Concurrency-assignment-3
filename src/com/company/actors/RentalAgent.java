package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.company.message.*;

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
                .match(RequestReservation.class, message -> {
                    actorRefMap.get(message.getLocation()).tell(new RequestRooms(getSender(), message.getRooms()), getSelf());
                })
                .match(ResponseRooms.class, message -> {
                    boolean bool = false;
                    if (message.getAvailableRooms() >= message.getRequestedRooms()) {
                        bool = true;
                    }
                    message.getSender().tell(new ResponseReservation(bool, getSender()), getSelf());
                })
                .build();
    }
}
