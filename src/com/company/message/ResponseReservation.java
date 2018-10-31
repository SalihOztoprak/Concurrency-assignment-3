package com.company.message;

import akka.actor.ActorRef;

public class ResponseReservation {
    private boolean succes;
    private ActorRef sender;

    public ResponseReservation(boolean succes, ActorRef sender) {
        this.succes = succes;
        this.sender = sender;
    }

    public boolean isSucces() {
        return succes;
    }

    public ActorRef getSender() {
        return sender;
    }
}
