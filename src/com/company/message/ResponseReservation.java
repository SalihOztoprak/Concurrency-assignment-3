package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseReservation {
    private String location;
    private String office;
    private boolean succes;
    private ActorRef sender;

    public ResponseReservation(String location, String office, boolean succes, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.succes = succes;
        this.sender = sender;
    }

    public boolean isSucces() {
        return succes;
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
