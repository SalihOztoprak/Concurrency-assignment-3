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
                .match(RequestListOfRooms.class, message -> {
                    actorRefMap.get(message.getLocation()).tell(message,getSelf());
                })
                .match(ResponseListOfRooms.class, message -> {
                    message.getSender().tell(message, getSelf());
                })
                .match(RequestReservation.class, message -> {
                    actorRefMap.get(message.getLocation()).tell(message,getSelf());
                })
                .match(ResponseReservation.class, message -> {
                    message.getSender().tell(message,getSelf());
                })
                .match(RequestBuyingOffice.class, message -> {
                    actorRefMap.get(message.getLocation()).tell(message,getSelf());
                })
                .match(ResponseBuyingOffice.class, message -> {
                    message.getSender().tell(message,getSelf());
                })
                .match(RequestAddToQueue.class, message -> {
                    actorRefMap.get(message.getLocation()).tell(message,getSelf());
                })
                .match(ResponseAddToQueue.class, message -> {
                    message.getSender().tell(message,getSelf());
                })
                .match(RequestRoomIsAvailableAgain.class, message -> {
                    actorRefMap.get(message.getLocation()).tell(message,getSelf());
                })
                .match(ResponseRoomIsAvailableAgain.class, message -> {
                    message.getSender().tell(message,getSelf());
                })
                .build();
    }
}
