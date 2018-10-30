package com.company.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public abstract class Person extends AbstractActor {
    protected String name;
    protected ActorSystem system;


    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);

    @Override
    public Receive createReceive() {
        return null;
    }

    public String getName() {
        return name;
    }
}
