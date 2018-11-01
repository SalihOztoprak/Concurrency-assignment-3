package com.company.message;

import akka.actor.ActorRef;

public class RequestListOfRooms {
    private String location;
    private ActorRef sender;

    public RequestListOfRooms(String location, ActorRef sender) {
        this.location = location;
        this.sender = sender;
    }

    public String getLocation() {
        return location;
    }

    public ActorRef getSender() {
        return sender;
    }
}
