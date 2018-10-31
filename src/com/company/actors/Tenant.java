package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.company.message.RequestLocations;
import com.company.message.RequestReservation;
import com.company.message.ResponseLocations;
import com.company.message.ResponseReservation;

import java.util.Arrays;
import java.util.Random;

public class Tenant extends AbstractLoggingActor {
    private ActorRef customerService;

    public Tenant(ActorRef customerService) {
        this.customerService = customerService;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        log().info("The customerservice is: " + customerService);
        requestLocations();
    }

    private void requestLocations() {
        log().info("Sending request to: " + customerService);
        customerService.tell(new RequestLocations(), getSelf());
        log().info("Sent!");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ResponseLocations.class, msg -> {
                    log().info(Arrays.toString(msg.getLocations()));
                    getSender().tell(new RequestReservation(getRandomLocation(msg.getLocations()),new Random().nextInt(3)+1),getSelf());
                    log().info("I've sent a request to " + getSender());
                })
                .match(ResponseReservation.class, msg -> {
                    log().info(msg.toString());
                })
                .build();
    }

    private String getRandomLocation(String[] locations) {
        return locations[new Random().nextInt(locations.length)];
    }
}
