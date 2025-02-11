package com.thentrees.virtualthreads.sequencecollection;

import java.util.LinkedHashMap;
import java.util.SequencedMap;

public class SequenceCollectionSample {

    public static void main(String[] args) {
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();

        sequencedMap.put(1, "One");
        sequencedMap.put(2, "Two");
        sequencedMap.put(3, "Three");

        System.out.println( "First: "+ sequencedMap.firstEntry());
        System.out.println( "First: "+ sequencedMap.lastEntry());
        // Loại bỏ phần tử đầu tiên và cuối cùng
        sequencedMap.pollFirstEntry();
        sequencedMap.pollLastEntry();
        System.out.println("After poll: " + sequencedMap);

        // string template
        int x = 2;
        int y = 2;

        String lorem = STR."String template -> ${x + y}";
        System.out.println(lorem);

    }

}
