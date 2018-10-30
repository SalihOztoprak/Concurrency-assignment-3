package com.company;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("HIApp");
        ActorRef hiActor = system.actorOf(Props.create(HiActor.class), "HiActor");
        hiActor.tell(Message.CANIRENT, ActorRef.noSender());
        hiActor.tell(Message.AVAILABLE, ActorRef.noSender());
        hiActor.tell(Message.UNAVAILABLE, ActorRef.noSender());
        hiActor.tell(Message.RENTED, ActorRef.noSender());
        hiActor.tell("Daaag", ActorRef.noSender());
        system.terminate();
    }

}
