package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestRoomIsAvailableAgain {
    private String location;
    private String office;
    private ActorRef sender;

    public RequestRoomIsAvailableAgain(String location, String office, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.sender = sender;
    }

    public String getLocation() {
        return location;
    }

    public String getOffice() {
        return office;
    }

    public ActorRef getSender() {
        return sender;
    }
}
