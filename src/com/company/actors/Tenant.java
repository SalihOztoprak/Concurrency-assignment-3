package com.company.actors;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.company.message.RequestLocations;
import com.company.message.ResponseLocations;

import java.util.Arrays;

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
//                    System.out.println("Hallo ik ben een tenant, dit zijn mn locaties: " + Arrays.toString(msg.getLocations()));
                })
                .build();
    }
}
