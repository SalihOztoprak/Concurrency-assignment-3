package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseListOfRooms {
    private Office[] offices;
    private String location;
    private ActorRef sender;

    public ResponseListOfRooms(Office[] offices, String location, ActorRef sender) {
        this.offices = offices;
        this.location = location;
        this.sender = sender;
    }

    public Office[] getOffices() {
        return offices;
    }

    public String getLocation() {
        return location;
    }

    public ActorRef getSender() {
        return sender;
    }
}
