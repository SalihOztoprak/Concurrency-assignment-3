package com.company.message;


import akka.actor.ActorRef;

public class ResponseRoomIsAvailableAgain {
    private int moneyToPay;
    private ActorRef sender;

    /**
     *
     * @param moneyToPay the amount of payment
     * @param sender of the message
     */
    public ResponseRoomIsAvailableAgain(int moneyToPay, ActorRef sender) {
        this.moneyToPay = moneyToPay;
        this.sender = sender;
    }

    /**
     * get the amount you have to pay
     * @return the amount of payment
     */
    public double getMoneyToPay() {
        return moneyToPay;
    }

    /**
     * get the sender
     * @return the sender
     */
    public ActorRef getSender() {
        return sender;
    }
}
