package com.company;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.company.actors.CustomerService;
import com.company.actors.Tenant;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        ActorSystem system = ActorSystem.create("World");

        ActorRef customerService = system.actorOf(Props.create(CustomerService.class));

        for (int i = 0; i < 5; i++) {
            system.actorOf(Props.create(Tenant.class, customerService));
        }
    }


}
