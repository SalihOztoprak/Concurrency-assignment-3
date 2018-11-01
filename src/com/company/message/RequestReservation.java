package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestReservation {
    private String location;
    private Office office;
    private ActorRef sender;

    public RequestReservation(String location, Office office, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.sender = sender;
    }

    public String getLocation() {
        return location;
    }

    public Office getOffice() {
        return office;
    }

    public ActorRef getSender() {
        return sender;
    }
}
