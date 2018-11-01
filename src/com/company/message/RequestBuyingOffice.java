package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestBuyingOffice {
    private String location;
    private Office office;
    private boolean iWantToBuyThisOffice;
    private ActorRef sender;
    private boolean payed;

    public RequestBuyingOffice(String location, Office office, boolean iWantToBuyThisOffice, ActorRef sender) {
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

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public boolean isPayed() {
        return payed;
    }

    public String getLocation() {
        return location;
    }

    public Office getOffice() {
        return office;
    }
}
