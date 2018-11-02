package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseReservation {
    private String location;
    private String office;
    private boolean succes;
    private ActorRef sender;

    /**
     *
     * @param location of the reservation
     * @param office of the reservation
     * @param succes if the reservation is a success
     * @param sender of the message
     */
    public ResponseReservation(String location, String office, boolean succes, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.succes = succes;
        this.sender = sender;
    }

    /**
     * check if the reservation is a success
     * @return the state of reservation
     */
    public boolean isSucces() {
        return succes;
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
