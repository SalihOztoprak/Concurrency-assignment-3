package com.company.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import com.company.Message;

public class Tenant extends Person {
    protected ActorRef customerService;


    public static void main(String[] args) {
        new Tenant("Salih").run();
    }

    public Tenant(String name) {
        super(name);
        customerService = system.actorOf(Props.create(CustomerService.class));
    }

    private void run(){
        customerService.tell(Message.REQUEST_LOCATIONS,ActorRef.noSender());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Object.class, (Object msg) -> {
            if (msg instanceof CustomerService) {
                System.out.println("Reactie ontvangen");
            }
        }).build();
    }
}
