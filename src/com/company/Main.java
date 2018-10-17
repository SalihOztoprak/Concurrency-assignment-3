package com.company;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.company.actors.LocationAgent;
import com.company.actors.RentalAgent;

public class Main {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("HIApp");
        ActorRef hiActor = system.actorOf(Props.create(HiActor.class), "HiActor");
        hiActor.tell(Message.HI, ActorRef.noSender());
        hiActor.tell(Message.HELLO, ActorRef.noSender());
        hiActor.tell(Message.NO_GREETING, ActorRef.noSender());
        hiActor.tell(Message.INSULT, ActorRef.noSender());
        hiActor.tell("Daaag", ActorRef.noSender());
        system.terminate();
    }

}
