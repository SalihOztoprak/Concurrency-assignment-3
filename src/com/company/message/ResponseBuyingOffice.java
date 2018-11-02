package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseBuyingOffice {
    private String location;
    private String office;
    private ActorRef sender;

    /**
     *
     * @param location of the renting place
     * @param office of the renting place
     * @param sender of the message
     */
    public ResponseBuyingOffice(String location, String office, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.sender = sender;
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
