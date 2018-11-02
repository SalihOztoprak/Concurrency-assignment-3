package com.company.message;

import akka.actor.ActorRef;

public class RequestListOfRooms {
    private String location;
    private ActorRef sender;


    /**
     *
     * @param location of the rooms
     * @param sender of the message
     */
    public RequestListOfRooms(String location, ActorRef sender) {
        this.location = location;
        this.sender = sender;
    }

    /**
     * get the location of the rooms
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * get the sender
     * @return the sender
     */
    public ActorRef getSender() {
        return sender;
    }
}
