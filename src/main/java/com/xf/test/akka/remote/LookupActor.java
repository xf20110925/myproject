package com.xf.test.akka.remote;

import akka.actor.*;
import scala.concurrent.duration.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LookupActor extends UntypedActor {

    private final String path;
    private ActorSelection selection = null;

    public LookupActor(String path) {
        this.path = path;
        selection = getContext().actorSelection(path);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String){
            selection.tell(message, getSelf());
        }
    }
}
