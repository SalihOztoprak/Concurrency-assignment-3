package com.company.message;


import akka.actor.ActorRef;

public class ResponseRoomIsAvailableAgain {
    private int moneyToPay;
    private ActorRef sender;

    public ResponseRoomIsAvailableAgain(int moneyToPay, ActorRef sender) {
        this.moneyToPay = moneyToPay;
        this.sender = sender;
    }

    public double getMoneyToPay() {
        return moneyToPay;
    }

    public ActorRef getSender() {
        return sender;
    }
}
