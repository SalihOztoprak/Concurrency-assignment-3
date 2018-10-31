package com.company;
//TODO make variables final

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.company.actors.CustomerService;
import com.company.actors.LocationAgent;
import com.company.actors.Tenant;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        ActorSystem system = ActorSystem.create("World");

        system.actorOf(Props.create(Tenant.class));
        system.actorOf(Props.create(CustomerService.class));
    }
}
