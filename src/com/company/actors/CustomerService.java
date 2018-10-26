package com.company.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import com.company.Message;

import java.util.Arrays;

public class CustomerService extends Person {
    private ActorRef tenant;
    private ActorRef rentalAgent;

    private String[] locations = {
            "Amsterdam",
            "Rotterdam",
            "Den Haag",
            "Utrecht",
            "Groningen",
            "Eindhoven",
            "Maastricht",
            "Enschede"
    };

    public CustomerService(String name) {
        super(name);
        tenant = system.actorOf(Props.create(Tenant.class));
        rentalAgent = system.actorOf(Props.create(RentalAgent.class));
    }

    public Receive createReceive() {
        return receiveBuilder().match(Message.class, greeting -> {
            switch (greeting) {
                case REQUEST_LOCATIONS:
                    System.out.println(Arrays.toString(locations));
                    break;
                default:
                    System.out.println("Sorry bra, ik niet begrijp.");
                    break;
            }
        }).build();
    }
}
