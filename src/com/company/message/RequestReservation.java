package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestReservation {
    private String location;
    private String office;
    private ActorRef sender;

    /**
     *
     * @param location of the location
     * @param office of the reservation
     * @param sender of the message
     */
    public RequestReservation(String location, String office, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.sender = sender;
    }

    /**
     * get the location of the reservation
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * get the office of the reservation
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * get the sender
     * @return the sender
     */
    public ActorRef getSender() {
        return sender;
    }
}
