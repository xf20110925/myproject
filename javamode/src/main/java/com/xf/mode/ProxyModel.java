package com.xf.mode;

/**
 * Created by xuefeng on 2017-11-2.
 * 代理的优点
 * <p>
 * 隐藏委托类的实现，调用者只需要和代理类进行交互即可。
 * 解耦，在不改变委托类代码情况下做一些额外处理，比如添加初始判断及其他公共操作
 * <p>
 * 简单代理模式
 */
public class ProxyModel {
    interface Interface {
        void doSomething();

        void somethingElse(String arg);
    }

    static class Realobject implements Interface {

        @Override
        public void doSomething() {
            System.out.println("do something");
        }

        @Override
        public void somethingElse(String arg) {
            System.out.println("do string else -> " + arg);
        }
    }

    static class SimpleProxy implements Interface {

        private Interface anInterface;

        public SimpleProxy(Interface anInterface) {
            this.anInterface = anInterface;
        }

        @Override
        public void doSomething() {
            System.out.println("init operation");
            anInterface.doSomething();
        }

        @Override
        public void somethingElse(String arg) {
            System.out.println("init some other opetation");
            anInterface.somethingElse(arg);
        }
    }

    static class ProxyTest {
        public void consume(Interface itf) {
            itf.doSomething();
            itf.somethingElse("test");
        }

        public static void main(String[] args) {
            new ProxyTest().consume(new Realobject());
            new ProxyTest().consume(new SimpleProxy(new Realobject()));
        }
    }
}
