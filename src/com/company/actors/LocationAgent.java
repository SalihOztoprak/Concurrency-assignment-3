package com.company.actors;

import akka.actor.AbstractLoggingActor;
import com.company.Office;
import com.company.message.*;

import java.util.Random;

public class LocationAgent extends AbstractLoggingActor {
    private String city;
    private Office[] offices;

    public LocationAgent(String city) {
        this.city = city;
        this.offices = new Office[new Random().nextInt(20) + 5];

        for (int i = 0; i < offices.length; i++) {
            offices[i] = new Office("Office " + i);
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestListOfRooms.class, message -> {
                    getSender().tell(new ResponseListOfRooms(offices, city, message.getSender()), getSelf());
                })
                .match(RequestReservation.class, message -> {
                    Office office = message.getOffice();
                    boolean isSucces = false;
                    if (!office.isReserved()) {
                        isSucces = true;
                    }
                    getSender().tell(new ResponseReservation(message.getLocation(), message.getOffice(), isSucces, message.getSender()), getSelf());
                })
                .match(RequestBuyingOffice.class, message -> {
                    if (message.iWantToBuyThisOffice()) {
                        boolean youGotTheRoom = false;
                        if (message.isPayed()) {
                            message.getOffice().setReserved(true);
                            youGotTheRoom = true;
                        }
                        getSender().tell(new ResponseBuyingOffice(message.getLocation(), message.getOffice(), youGotTheRoom, message.getSender()), getSelf());
                    }
                })
                .match(RequestAddToQueue.class, message -> {
                    if (message.iWantToBeInTheQueue()) {
                        message.getOffice().addToQueue(message.getSender());
                        getSender().tell(new ResponseAddToQueue(message.getLocation(), message.getOffice(), message.getSender()), getSelf());
                    }
                })
                .match(RequestRoomIsAvailableAgain.class, message -> {
                    getSender().tell(new ResponseRoomIsAvailableAgain(new Random().nextInt(30) + 10, message.getSender()), getSelf());
                    if (!message.getOffice().getQueue().isEmpty()) {
                        message.getOffice().getQueue().peek().tell(new ResponseReservation(message.getLocation(), message.getOffice(), true, message.getOffice().getQueue().peek()), getSelf());
                        message.getOffice().getQueue().poll();
                    } else {
                        message.getOffice().setReserved(false);
                    }
                })
                .build();
    }
}
