package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class RequestAddToQueue {
    private String location;
    private String office;
    private boolean iWantToBeInTheQueue;
    private ActorRef sender;

    public RequestAddToQueue(String location, String office, boolean iWantToBeInTheQueue, ActorRef sender) {
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

    public String getOffice() {
        return office;
    }
}
