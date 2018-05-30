package com.xf.test.akka.remote;

import akka.actor.UntypedActor;

/**
 * Created by xuefeng on 2018-5-29.
 */
public class HelloRemoteActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println(message.toString());
    }
}
