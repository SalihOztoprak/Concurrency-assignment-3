package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseAddToQueue {
    private String location;
    private String office;
    private ActorRef sender;

    public ResponseAddToQueue(String location, String office, ActorRef sender) {
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

    public String getOffice() {
        return office;
    }
}
