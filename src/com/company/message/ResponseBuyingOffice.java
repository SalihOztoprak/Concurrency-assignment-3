package com.company.message;

import akka.actor.ActorRef;
import com.company.Office;

public class ResponseBuyingOffice {
    private String location;
    private Office office;
    private boolean youGotTheRoom;
    private ActorRef sender;

    public ResponseBuyingOffice(String location, Office office, boolean youGotTheRoom, ActorRef sender) {
        this.location = location;
        this.office = office;
        this.youGotTheRoom = youGotTheRoom;
        this.sender = sender;
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

    public boolean isYouGotTheRoom() {
        return youGotTheRoom;
    }
}
