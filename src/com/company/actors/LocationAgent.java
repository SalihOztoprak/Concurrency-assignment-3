package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import com.company.Office;
import com.company.message.*;

import java.util.ArrayList;
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
                    getSender().tell(new ResponseListOfRooms(offices,city,message.getSender()),getSelf());
                })
                .match(RequestReservation.class, message -> {
                    Office office = message.getOffice();
                    boolean isSucces = false;
                    if (office.isReserved()){
                        office.addToQueue(getSender());
                    } else {
                        office.setReserved(true);
                        isSucces = true;
                    }
                    getSender().tell(new ResponseReservation(isSucces,message.getSender()),getSelf());
                    log().info("I've send a response (Location)");
                })
                .build();
    }

    public String getCity() {
        return city;
    }

    public Office[] getOffices() {
        return offices;
    }
}
