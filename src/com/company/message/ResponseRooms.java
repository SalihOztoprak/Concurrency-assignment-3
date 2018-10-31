package com.company.message;

import akka.actor.ActorRef;

public class ResponseRooms {
    private ActorRef sender;
    private int availableRooms;
    private int requestedRooms;

    public ResponseRooms(ActorRef sender, int availableRooms, int requestedRooms) {
        this.sender = sender;
        this.availableRooms = availableRooms;
        this.requestedRooms = requestedRooms;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public ActorRef getSender() {
        return sender;
    }

    public int getRequestedRooms() {
        return requestedRooms;
    }
}
