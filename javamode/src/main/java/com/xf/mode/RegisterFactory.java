package com.xf.mode;
import java.util.ArrayList;
import java.util.List;

/**
 * 注册工厂模式
 * Created by xuefeng on 2017-11-1.
 */
public class RegisterFactory {
    interface MyFactory<T> {
        T create();
    }

    static class Pet {
        List<MyFactory<? extends Pet>> factories = new ArrayList<>();

        {
            factories.add(new Dog.DogFactory());
            factories.add(new Cat.CatFactory());
        }

        public Pet getInstance() {
            return factories.get(0).create();
        }
    }

    static class Dog extends Pet {
        static class DogFactory implements MyFactory<Dog> {

            @Override
            public Dog create() {
                return new Dog();
            }
        }
    }

    static class Cat extends Pet {
        static class CatFactory implements MyFactory<Cat> {

            @Override
            public Cat create() {
                return new Cat();
            }
        }
    }


}
