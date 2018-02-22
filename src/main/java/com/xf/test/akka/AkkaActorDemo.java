package com.xf.test.akka;

import akka.actor.*;
import scala.concurrent.duration.Duration;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by xuefeng on 2018-2-22.
 */
public class AkkaActorDemo {

    /**
     * 用于表示执行打招呼这个操作的消息
     */
    static class Greet implements Serializable {
    }

    /**
     * 招呼体,里面有打的什么招呼
     */
    static class Greeting implements Serializable {
        public final String message;

        public Greeting(String message) {
            this.message = message;
        }
    }

    /**
     * 打招呼的人
     */
    static class WhoToGreet implements Serializable {
        public final String who;

        public WhoToGreet(String who) {
            this.who = who;
        }
    }

    /**
     * 打招呼的actor
     */
    static class Greeter extends UntypedActor {
        String greeting = "";

        @Override
        public void onReceive(Object message) throws Exception {
            if (message instanceof WhoToGreet) {
                greeting = String.format("hello -> %s", ((WhoToGreet) message).who);
            } else if (message instanceof Greet) {
                // 发送招呼消息给发送消息给这个Actor的Actor
                getSender().tell(new Greeting(greeting), getSelf());
            } else {
                unhandled(message);
            }

        }
    }

    /**
     * 打印招呼
     */
    static class GreetPrinter extends UntypedActor {
        @Override
        public void onReceive(Object message) throws Exception {
            if (message instanceof Greeting)
                System.out.println(((Greeting) message).message);
        }
    }

    public static void main(String[] args) {
        final ActorSystem actorSystem = ActorSystem.create("helloAkka");

        //创建一个到greeter actor的管道
        final ActorRef greeter = actorSystem.actorOf(Props.create(Greeter.class), "greeter");

        //创建邮箱
        final Inbox inbox = Inbox.create(actorSystem);

        //先发第一个消息，消息类型为WhoToGreet
        greeter.tell(new WhoToGreet("akka"), ActorRef.noSender());

        // 真正的发送消息,消息体为Greet
        inbox.send(greeter, new Greet());

        // 等待5秒尝试接收Greeter返回的消息
        final Greeting greeting1 = (Greeting) inbox.receive(Duration.create(5, TimeUnit.SECONDS));
        System.out.println("Greeting:" + greeting1.message);

        //发送第三个消息，修改名字
        greeter.tell(new WhoToGreet("typesafe"), ActorRef.noSender());

        // 发送第四个消息
        inbox.send(greeter, new Greet());

        //等待5秒尝试接收Greeter返回的消息
        final Greeting greeting2 = (Greeting) inbox.receive(Duration.create(5, TimeUnit.SECONDS));
        System.out.println("Greeting:" + greeting2.message);

        //新建一个Actor的管道
        final ActorRef greetPrinter = actorSystem.actorOf(Props.create(GreetPrinter.class));

        //使用schedule 每一秒发送一个Greet消息给 greeterActor,然后把greeterActor的消息返回给greetPrinterActor
        actorSystem.scheduler().schedule(Duration.Zero(), Duration.create(1, TimeUnit.SECONDS), greeter, new Greet(), actorSystem.dispatcher(), greetPrinter);

    }
}
