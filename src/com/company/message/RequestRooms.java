package com.company.message;

import akka.actor.ActorRef;

public class RequestRooms {
    private ActorRef sender;
    private int requestedRooms;

    public RequestRooms(ActorRef sender) {
        this.sender = sender;
        this.requestedRooms = requestedRooms;
    }

    public ActorRef getSender() {
        return sender;
    }

    public int getRequestedRooms() {
        return requestedRooms;
    }
}
