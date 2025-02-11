package com.thentrees.lambdaexpresion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaSample {

    public static void main(String[] args) {

        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;

        System.out.println(comparator.compare(1, 2));

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Lọc và in tên có độ dài lớn hơn 3
        names.stream()
                .filter(name -> name.length() > 3)
                .forEach(name -> System.out.println(name));
    }

}
//chir su dung voi @FunctionalInterface(interface chi co 1 method)