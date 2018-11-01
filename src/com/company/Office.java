package com.company;

import akka.actor.ActorRef;

import java.util.ArrayList;

public class Office {
    private String name;
    private boolean isReserved;
    private ArrayList<ActorRef> queue;

    public Office(String name) {
        this.name = name;
        this.isReserved = false;
        this.queue = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public ArrayList<ActorRef> getQueue() {
        return queue;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public void addToQueue(ActorRef waitingPerson) {
        queue.add(waitingPerson);
    }

    @Override
    public String toString() {
        return name;
    }
}
