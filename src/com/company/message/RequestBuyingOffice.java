package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestBuyingOffice {
    private String location;
    private String office;
    private boolean iWantToBuyThisOffice;
    private ActorRef sender;

    public RequestBuyingOffice(String location, String office, boolean iWantToBuyThisOffice, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.iWantToBuyThisOffice = iWantToBuyThisOffice;
        this.sender = sender;
    }

    public boolean iWantToBuyThisOffice() {
        return iWantToBuyThisOffice;
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
