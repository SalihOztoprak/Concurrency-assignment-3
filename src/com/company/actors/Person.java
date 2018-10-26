package com.company.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.company.testing.Consumer;

public abstract class Person extends AbstractActor {
    protected String name;
    protected ActorSystem system;

    public Person(String name) {
        this.name = name;
        system = ActorSystem.create("MessagePassing");
    }

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);

    @Override
    public Receive createReceive() {
        return null;
    }

    public String getName() {
        return name;
    }
}
