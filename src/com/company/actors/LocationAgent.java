package com.company.actors;

import akka.actor.AbstractLoggingActor;
import com.company.Office;
import com.company.message.*;

import java.util.*;

public class LocationAgent extends AbstractLoggingActor {
    private String city;
    private HashMap<String,Office> offices;

    /**
     *
     * @param city of the location agent
     */
    public LocationAgent(String city) {
        this.city = city;
        this.offices = new HashMap<>();

        for (int i = 0; i < new Random().nextInt(20) + 5; i++) {
            offices.put("Office " + i,new Office("Office " + i));
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestListOfRooms.class, message -> {
                    String[] officesString = getOffices();
                    getSender().tell(new ResponseListOfRooms(officesString, city, message.getSender()), getSelf());
                })
                .match(RequestReservation.class, message -> {
                    Office office = offices.get(message.getOffice());
                    boolean isSucces = false;
                    if (!office.isReserved()) {
                        isSucces = true;
                    }
                    getSender().tell(new ResponseReservation(message.getLocation(), message.getOffice(), isSucces, message.getSender()), getSelf());
                })
                .match(RequestBuyingOffice.class, message -> {
                    Office office = offices.get(message.getOffice());
                    if (message.iWantToBuyThisOffice()) {
                        office.setReserved(true);
                        getSender().tell(new ResponseBuyingOffice(message.getLocation(), message.getOffice(), message.getSender()), getSelf());
                    }
                })
                .match(RequestAddToQueue.class, message -> {
                    Office office = offices.get(message.getOffice());
                    if (message.iWantToBeInTheQueue()) {
                        office.addToQueue(message.getSender());
                        getSender().tell(new ResponseAddToQueue(message.getLocation(), message.getOffice(), message.getSender()), getSelf());
                    }
                })
                .match(RequestRoomIsAvailableAgain.class, message -> {
                    Office office = offices.get(message.getOffice());
                    getSender().tell(new ResponseRoomIsAvailableAgain(new Random().nextInt(30) + 10, message.getSender()), getSelf());
                    if (!office.getQueue().isEmpty()) {
                        office.getQueue().peek().tell(new ResponseReservation(message.getLocation(), message.getOffice(), true, office.getQueue().peek()), getSelf());
                        office.getQueue().poll();
                    } else {
                        office.setReserved(false);
                    }
                })
                .build();
    }

    /**
     * get the offices
     * @return the offices
     */
    private String[] getOffices() {
        List<String> list = new ArrayList<>(offices.keySet());

        String[] offices = new String[list.size()];
        for (int i = 0; i < offices.length; i++) {
            offices[i] = list.get(i);
        }

        return offices;
    }
}
