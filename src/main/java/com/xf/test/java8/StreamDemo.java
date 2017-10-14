package com.xf.test.java8;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by xuefeng on 2017-10-13.
 */
public class StreamDemo {
    static class Car {
        private String name;
        private Integer amout;
        private Double price;

        public Car(String name, Integer amout, Double price) {
            this.name = name;
            this.amout = amout;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAmout() {
            return amout;
        }

        public void setAmout(Integer amout) {
            this.amout = amout;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

    public static void main(String[] args) throws IOException {
        final Stream<Car> stream = Arrays.asList(new Car("a", 1, 1d), new Car("b", 2, 2d), new Car("c", 3, 3d), new Car("d", 4, 0d)).stream();
        final Double salValue = stream.filter(car -> car.getPrice() != 0).map(car -> {
            return car.getAmout() * car.getPrice();
        }).reduce(0d, (c1, c2) -> c1 + c2);
        System.out.println(salValue);

        stream.sorted((c1, c2) -> c1.getAmout() - c2.getAmout());
        stream.sorted(Comparator.comparing(Car::getName));

        final List<String> lines = Files.lines(Paths.get("/Users/xuefeng/Desktop/tmp.txt")).collect(Collectors.toList());
        System.out.println(lines.size());

        IntStream.range(0, 10).forEach(System.out::println);
    }


}
