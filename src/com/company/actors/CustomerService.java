package com.company.actors;

import akka.actor.ActorRef;
import java.util.HashMap;
import java.util.Map;

public class CustomerService extends Person {
    private ActorRef tenant;
    private ActorRef rentalAgent;

    private Map<String,LocationAgent> locationAgents = new HashMap<>();

//            "Amsterdam", ,
//            new LocationAgent("Frank", "Rotterdam", 10),
//            new LocationAgent("Ruud", "Den Haag", 8),
//            new LocationAgent("Gerralt", "Utrecht", 16),
//            new LocationAgent("Salih", "Groningen", 12),
//            new LocationAgent("Thomas", "Eindhoven", 27),
//            new LocationAgent("Timothy", "Maastricht", 19),
//            new LocationAgent("Tristan", "Enschede", 13)



    private void run(){
    }

    public Receive createReceive() {
        return receiveBuilder().match(Tenant.Messages.class, greeting -> {
            switch (greeting) {
                case REQUEST_LOCATIONS:
                    System.out.println("Locaties");
                    break;
                default:
                    System.out.println("Sorry bra, ik niet begrijp.");
                    break;
            }
        }).build();
    }
}
