package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseAddToQueue {
    private String location;
    private String office;
    private ActorRef sender;

    /**
     *
     * @param location of the reserving room
     * @param office of the reserving room
     * @param sender of the message
     */
    public ResponseAddToQueue(String location, String office, ActorRef sender) {
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
}
