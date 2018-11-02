package com.company.actors;

import akka.actor.*;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import com.company.message.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerService extends AbstractLoggingActor {
    private HashMap<String, ActorRef> actorRefMap;
    private Router router;

    /**
     *
     * @throws Exception
     */
    @Override
    public void preStart() throws Exception {
        super.preStart();

        createList();

        List<Routee> routees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActorRef rentalAgent = getContext().actorOf(RentalAgent.prop(actorRefMap));
            getContext().watch(rentalAgent);
            routees.add(new ActorRefRoutee(rentalAgent));
        }
        router = new Router(new RoundRobinRoutingLogic(), routees);
    }

    /**
     *
     * @return the message
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestLocations.class, message -> {
                    router.route(message, getSender());
                    String[] locations = getLocations();
                    getSender().tell(new ResponseLocations(locations), getSelf());
                })
                .match(RequestListOfRooms.class, message -> {
                    router.route(message, getSender());
                })
                .match(RequestReservation.class, message -> {
                    router.route(message, getSender());
                })
                .match(RequestBuyingOffice.class, message -> {
                    router.route(message, getSender());
                })
                .match(RequestAddToQueue.class, message -> {
                    router.route(message, getSender());
                })
                .match(RequestRoomIsAvailableAgain.class, message -> {
                    router.route(message, getSender());
                })
                .build();
    }

    /**
     * Create a list of locations
     */
    private void createList() {
        actorRefMap = new HashMap<>();
        actorRefMap.put("Enschede", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Enschede")));
        actorRefMap.put("Amsterdam", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Amsterdam")));
        actorRefMap.put("Deventer", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Deventer")));
        actorRefMap.put("Almelo", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Almelo")));
        actorRefMap.put("Goor", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Goor")));
    }

    /**
     * get the locations
     * @return the locations
     */
    private String[] getLocations() {
        List<String> list = new ArrayList<>(actorRefMap.keySet());

        String[] locations = new String[list.size()];
        for (int i = 0; i < locations.length; i++) {
            locations[i] = list.get(i);
        }

        return locations;
    }
}