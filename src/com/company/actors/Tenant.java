package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import com.company.Office;
import com.company.message.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Tenant extends AbstractLoggingActor {
    private ActorRef customerService;

    public Tenant(ActorRef customerService) {
        this.customerService = customerService;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        requestLocations();
    }

    private void requestLocations() {
        log().info("Sending request to: " + customerService);
        customerService.tell(new RequestLocations(), getSelf());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ResponseLocations.class, message -> {
                    log().info(Arrays.toString(message.getLocations()));
                    customerService.tell(new RequestListOfRooms(getRandomLocation(message.getLocations()), getSelf()), getSelf());
                })
                .match(ResponseListOfRooms.class, message -> {
                    log().info(Arrays.toString(message.getOffices()));
                    customerService.tell(new RequestReservation(message.getLocation(), getRandomOffice(message.getOffices()), getSelf()), getSelf());
                })
                .match(ResponseReservation.class, message -> {
                    if (message.isSucces()) {
                        boolean iWantToBuyThisOffice = new Random().nextBoolean();
                        customerService.tell(new RequestBuyingOffice(message.getLocation(), message.getOffice(), iWantToBuyThisOffice, getSelf()), getSelf());
                    } else {
                        boolean iWantToBeInTheQueue = new Random().nextBoolean();
                        customerService.tell(new RequestAddToQueue(message.getLocation(), message.getOffice(), iWantToBeInTheQueue, getSelf()), getSelf());
                    }
                })
                .match(ResponseBuyingOffice.class, message -> {
                    log().info("I have bought a room");
                    //Tenant now has the room and will use it (wait)
                    TimeUnit.SECONDS.sleep(new Random().nextInt(50)+10);
                    customerService.tell(new RequestRoomIsAvailableAgain(message.getLocation(), message.getOffice(), getSelf()), getSelf());
                })
                .match(ResponseRoomIsAvailableAgain.class, message -> {
                    log().info("I have returned my room");
                    log().info("I have to pay €" + message.getMoneyToPay());
                    //Tenant will wait again before reserving new room
                    TimeUnit.SECONDS.sleep(new Random().nextInt(50)+10);
                    requestLocations();
                })
                .build();
    }

    private String getRandomLocation(String[] locations) {
        return locations[new Random().nextInt(locations.length)];
    }

    private String getRandomOffice(String[] offices) {
        return offices[new Random().nextInt(offices.length)];
    }
}
