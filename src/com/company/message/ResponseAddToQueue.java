package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseAddToQueue {
    private String location;
    private Office office;
    private ActorRef sender;

    public ResponseAddToQueue(String location, Office office, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.sender = sender;
    }

    public ActorRef getSender() {
        return sender;
    }

    public String getLocation() {
        return location;
    }

    public Office getOffice() {
        return office;
    }
}
