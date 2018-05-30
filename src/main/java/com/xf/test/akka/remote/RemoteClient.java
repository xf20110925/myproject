package com.xf.test.akka.remote;

import akka.actor.*;
import com.typesafe.config.ConfigFactory;
import scala.concurrent.duration.Duration;

import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by xuefeng on 2018-5-29.
 */
public class RemoteClient {

    private static void startRemote() {
        final ActorSystem system = ActorSystem.create("LookupSystem",
                ConfigFactory.load("remotelookup"));
        final String path = "akka.tcp://RemoteSystemTest@127.0.0.1:2552/user/remoteactor";
        final ActorRef actor = system.actorOf(
                Props.create(LookupActor.class, path), "lookupActor");

        System.out.println("Started LookupSystem");
        final Random r = new Random();
        system.scheduler().schedule(Duration.create(1, SECONDS),
                Duration.create(1, SECONDS), new Runnable() {
                    @Override
                    public void run() {
                        actor.tell(String.valueOf(r.nextInt(100)), null);
                    }
                }, system.dispatcher());
    }

    public static void main(String[] args) {
        startRemote();
    }

}
