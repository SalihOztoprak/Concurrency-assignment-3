package com.company.actors;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public abstract class Person extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);

    @Override
    public Receive createReceive() {

        return null;
    }


}
