package com.xf.mode;

import java.lang.reflect.*;

/**
 * Created by xuefeng on 2017-11-2.
 * 动态代理模式
 */
public class DynamicProxy {
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

    static class DynamicProxyHandler implements InvocationHandler {

        private Object proxied;

        public DynamicProxyHandler(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(String.format("%s->%s->%s", proxy.getClass(), method, args));
            return method.invoke(proxied, args);
        }
    }

    static class ProxyTest {
        public void consume(Interface itf) {
            itf.doSomething();
            itf.somethingElse("test");
        }

        public static void main(String[] args) {
            new ProxyTest().consume(new Realobject());
            final Interface itf = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(new Realobject()));
            new ProxyTest().consume(itf);
        }
    }
}
