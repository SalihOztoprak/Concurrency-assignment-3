package com.company.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import com.company.testing.Message;

public class Tenant extends Person {
    protected ActorRef customerService;


    public static void main(String[] args) {
        new Tenant("Salih").run();
    }

    public Tenant(String name) {
        customerService = system.actorOf(Props.create(CustomerService.class));
    }

    private void run(){
        customerService.tell(Message.REQUEST_LOCATIONS,customerService);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Object.class, (Object msg) -> {
            if (msg instanceof CustomerService) {
                System.out.println("Reactie ontvangen");
            }
        }).build();
    }

    public enum Messages {
        REQUEST_LOCATIONS
    }
}
