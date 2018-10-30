package com.company.testing;

import akka.actor.*;

public class Consumer extends AbstractActor {

    public static void main(String[] args) {
        new Consumer().run();
    }

    private void run() {

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Object.class, (Object msg) -> {
            if (msg instanceof Integer) {
                ActorSystem system = ActorSystem.create("respond-back");
                ActorRef actor = system.actorOf(Props.create(Producer.class));
                System.out.println("<<< Receiving & printing " + msg);
                String message = "Thanks mate";
                System.out.println(message);
                actor.tell(message, ActorRef.noSender());
            }
        }).build();
    }
}