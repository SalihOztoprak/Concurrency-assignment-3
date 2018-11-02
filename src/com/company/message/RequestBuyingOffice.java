package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestBuyingOffice {
    private String location;
    private String office;
    private boolean iWantToBuyThisOffice;
    private ActorRef sender;

    /**
     *
     * @param location the location
     * @param office the office
     * @param iWantToBuyThisOffice check if the person wants this office
     * @param sender the sender
     */
    public RequestBuyingOffice(String location, String office, boolean iWantToBuyThisOffice, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.iWantToBuyThisOffice = iWantToBuyThisOffice;
        this.sender = sender;
    }

    /**
     * check if the person want to rent this office
     * @return the decisions
     */
    public boolean iWantToBuyThisOffice() {
        return iWantToBuyThisOffice;
    }

    /**
     * get the sender
     * @return the sender
     */
    public ActorRef getSender() {
        return sender;
    }

    /**
     * get the location
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * get the office
     * @return the office
     */
    public String getOffice() {
        return office;
    }
}
