package com.company.actors;

import akka.actor.*;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import com.company.message.RequestLocations;
import com.company.message.RequestReservation;
import com.company.message.ResponseLocations;
import com.company.message.ResponseReservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CustomerService extends AbstractLoggingActor {
    private HashMap<String, ActorRef> actorRefMap;
    private List<Routee> routees;
    private Router router;

    @Override
    public void preStart() throws Exception {
        super.preStart();

        createList();

        routees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ActorRef rentalAgent = getContext().actorOf(RentalAgent.prop(actorRefMap));
            getContext().watch(rentalAgent);
            routees.add(new ActorRefRoutee(rentalAgent));
        }
        router = new Router(new RoundRobinRoutingLogic(), routees);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestLocations.class, message -> {
                    log().info("Routing message :" + message);
                    router.route(message, getSender());
                    String[] locations = getLocations();
                    getSender().tell(new ResponseLocations(locations), getSelf());
                })
                .match(RequestReservation.class, message -> {
                    router.route(message,getSelf());
//                    routees.get(new Random().nextInt(5)).send(message, getSelf());
                })
                .match(ResponseReservation.class, msg -> {
                    msg.getSender().tell(msg,getSender());
                })
                .build();
    }

    private void createList() {
        actorRefMap = new HashMap<>();
        actorRefMap.put("Enschede", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Enschede")));
        actorRefMap.put("Amsterdam", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Amsterdam")));
        actorRefMap.put("Deventer", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Deventer")));
        actorRefMap.put("Almelo", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Almelo")));
        actorRefMap.put("Goor", getContext().getSystem().actorOf(Props.create(LocationAgent.class, "Goor")));
    }

    private String[] getLocations() {
        List<String> list = new ArrayList<>(actorRefMap.keySet());

        String[] locations = new String[list.size()];
        for (int i = 0; i < locations.length; i++) {
            locations[i] = list.get(i);
        }

        return locations;
    }
}