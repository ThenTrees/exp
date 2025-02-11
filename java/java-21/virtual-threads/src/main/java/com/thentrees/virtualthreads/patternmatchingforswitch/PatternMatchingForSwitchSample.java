package com.thentrees.virtualthreads.patternmatchingforswitch;

public class PatternMatchingForSwitchSample {

    public static void main(String[] args) {
        Object obj = "Hello World";

        String result = switch (obj) {
            case String s -> "Short String: " + s;
            case Integer i -> "Integer: " + i;
            default -> "Unknown type";
        };

        System.out.println(result);
    }

}
