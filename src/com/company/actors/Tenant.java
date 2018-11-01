package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import com.company.Office;
import com.company.message.*;

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
                .match(ResponseLocations.class, message -> {
                    log().info(Arrays.toString(message.getLocations()));
                    getSender().tell(new RequestListOfRooms(getRandomLocation(message.getLocations()), getSelf()), getSelf());
                })
                .match(ResponseListOfRooms.class, message -> {
                    log().info(Arrays.toString(message.getOffices()));
                    getSender().tell(new RequestReservation(message.getLocation(), getRandomOffice(message.getOffices()), getSender()), getSelf());
                })
                .match(ResponseReservation.class, message -> {
                    if (message.isSucces()) {
                        log().info("WOHOO I have a room");
                    } else {
                        log().info("Ahh no room for me");
                    }
                })
                .build();
    }

    private String getRandomLocation(String[] locations) {
        return locations[new Random().nextInt(locations.length)];
    }

    private Office getRandomOffice(Office[] offices) {
        return offices[new Random().nextInt(offices.length)];
    }
}
