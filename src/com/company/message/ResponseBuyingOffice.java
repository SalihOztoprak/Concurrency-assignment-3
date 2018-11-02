package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseBuyingOffice {
    private String location;
    private String office;
    private ActorRef sender;

    public ResponseBuyingOffice(String location, String office, ActorRef sender) {
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
