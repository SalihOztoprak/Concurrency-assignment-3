package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestAddToQueue {
    private String location;
    private Office office;
    private boolean iWantToBeInTheQueue;
    private ActorRef sender;

    public RequestAddToQueue(String location, Office office, boolean iWantToBeInTheQueue, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.iWantToBeInTheQueue = iWantToBeInTheQueue;
        this.sender = sender;
    }

    public boolean iWantToBeInTheQueue() {
        return iWantToBeInTheQueue;
    }

    public ActorRef getSender() {
        return sender;
    }

    public String getLocation() {
        return location;
    }

    public Office getOffice() {
        return office;
    }
}
