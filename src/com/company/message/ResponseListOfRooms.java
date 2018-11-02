package com.company.message;

import akka.actor.ActorRef;

public class ResponseListOfRooms {
    private String[] offices;
    private String location;
    private ActorRef sender;

    public ResponseListOfRooms(String[] offices, String location, ActorRef sender) {
        this.offices = offices;
        this.location = location;
        this.sender = sender;
    }

    public String[] getOffices() {
        return offices;
    }

    public String getLocation() {
        return location;
    }

    public ActorRef getSender() {
        return sender;
    }
}
