package com.xf.test.akka.remote;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by xuefeng on 2018-5-29.
 */
public class RemoteStarter {

    private static void startRemote() {
        final ActorSystem system = ActorSystem.create("RemoteSystemTest", ConfigFactory.load(("helloremote")));
        system.actorOf(Props.create(HelloRemoteActor.class), "remoteactor");
        System.out.println("Started RemoteSystemTest");
    }

    public static void main(String[] args) {
        startRemote();
    }
}
