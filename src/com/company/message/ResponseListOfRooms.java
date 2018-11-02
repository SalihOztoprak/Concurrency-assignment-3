package com.company.message;

import akka.actor.ActorRef;

public class ResponseListOfRooms {
    private String[] offices;
    private String location;
    private ActorRef sender;

    /**
     *
     * @param offices of the response list
     * @param location of the response list
     * @param sender of the message
     */
    public ResponseListOfRooms(String[] offices, String location, ActorRef sender) {
        this.offices = offices;
        this.location = location;
        this.sender = sender;
    }

    /**
     * get the offices
     * @return the office
     */
    public String[] getOffices() {
        return offices;
    }

    /**
     * get the locations
     * @return the locations
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
