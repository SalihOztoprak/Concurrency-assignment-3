package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestRoomIsAvailableAgain {
    private String location;
    private String office;
    private ActorRef sender;

    /**
     *
     * @param location of the room
     * @param office of the room
     * @param sender of the message
     */
    public RequestRoomIsAvailableAgain(String location, String office, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.sender = sender;
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

    /**
     * get the sender
     * @return the sender
     */
    public ActorRef getSender() {
        return sender;
    }
}
