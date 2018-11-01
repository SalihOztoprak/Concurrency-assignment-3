package com.company;

import akka.actor.ActorRef;

import java.util.LinkedList;
import java.util.Queue;

public class Office {
    private String name;
    private boolean isReserved;
    private Queue<ActorRef> queue;

    public Office(String name) {
        this.name = name;
        this.isReserved = false;
        this.queue = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public Queue<ActorRef> getQueue() {
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
