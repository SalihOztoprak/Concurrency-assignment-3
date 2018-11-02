package com.company;

import akka.actor.ActorRef;

import java.util.LinkedList;
import java.util.Queue;

public class Office {
    private String name;
    private boolean isReserved;
    private Queue<ActorRef> queue;

    /**
     *
     * @param name of the office
     */
    public Office(String name) {
        this.name = name;
        this.isReserved = false;
        this.queue = new LinkedList<>();
    }


    /**
     * check if the room reserved
     * @return the check if the room is reserved
     */
    public boolean isReserved() {
        return isReserved;
    }

    /**
     * get the queue
     * @return the queue
     */
    public Queue<ActorRef> getQueue() {
        return queue;
    }

    /**
     * set the room reserved
     * @param reserved the room status
     */
    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    /**
     * add a new person to the que
     * @param waitingPerson a new person
     */
    public void addToQueue(ActorRef waitingPerson) {
        queue.add(waitingPerson);
    }

    @Override
    public String toString() {
        return name;
    }
}
