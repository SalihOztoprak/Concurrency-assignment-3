package com.company.testing;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Producer extends AbstractActor {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("generate-numbers-one-to-ten");
        ActorRef printNumbersConsumer = system.actorOf(Props.create(Consumer.class));

        for (int i = 1; i <= 10; i++) {
            System.out.println(">>> Producing & sending a number " +  i);
            printNumbersConsumer.tell(i, ActorRef.noSender());
        }

        System.out.println("===== Finished producing & sending numbers 1 to 10");

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Object.class, message ->{
            if (message.equals("Thanks mate")) {
                System.out.println("You're welcome");
            }
        }).build();
    }
}