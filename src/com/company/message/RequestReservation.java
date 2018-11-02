package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestReservation {
    private String location;
    private String office;
    private ActorRef sender;

    public RequestReservation(String location, String office, ActorRef sender) {
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
