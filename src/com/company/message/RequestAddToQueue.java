package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestAddToQueue {
    private String location;
    private String office;
    private boolean iWantToBeInTheQueue;
    private ActorRef sender;

    /**
     *
     * @param location The location
     * @param office The office
     * @param iWantToBeInTheQueue if the person is in queue
     * @param sender the sender
     */
    public RequestAddToQueue(String location, String office, boolean iWantToBeInTheQueue, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.iWantToBeInTheQueue = iWantToBeInTheQueue;
        this.sender = sender;
    }

    /**
     * check if the person is in the que
     * @return if the person is in the que
     */
    public boolean iWantToBeInTheQueue() {
        return iWantToBeInTheQueue;
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
