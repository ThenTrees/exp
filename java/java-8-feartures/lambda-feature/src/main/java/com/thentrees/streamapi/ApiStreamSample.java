package com.thentrees.streamapi;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ApiStreamSample {

    public static void main(String[] args) {

        // Creating a Stream of Strings
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        // stream builder duoc dung khi muon them 1 phan tu moi vao ben phai
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();

        // Stream.generate() duoc dung khi muon tao ra 1 stream vo han (phai dung limit de gioi han)
        Stream<String> streamGenerated =
                Stream.generate(() -> "stackjava").limit(10);

        // Stream.iterate() duoc dung khi muon tao ra 1 stream co gia tri duoc tinh toan tu gia tri truoc do
//        IntStream intStream = IntStream.range(1, 3);

//        System.out.println(" intStream: " +intStream);
        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("a, b, c");

        System.out.println(" streamOfString: " +streamOfString);

        Stream<Integer> intStream = Stream.of(1,2,3,4);
        List<Integer> intList = intStream.collect(Collectors.toList());
        System.out.println(intList); //prints [1, 2, 3, 4]
        intStream = Stream.of(1,2,3,4); //stream bị đóng nên cần khởi tạo lại (*đọc phần lưu ý cuối bài)
        Map<Integer,Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i+10));
        System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}

        Predicate<Integer> p = num -> num % 2 == 0; // predicate dung de tao 1 dieu kien
        List<Integer> list = Arrays.asList(3,4,6);
        list.stream().filter(p).forEach(e -> System.out.print(e+" "));

        Predicate<Integer> p1 = num -> num % 2 == 0;
        List<Integer> list1 = Arrays.asList(3,5,6);
        System.out.println("allMatch:" + list.stream().allMatch(p)); // true neu all phan tu khop voi predidate
        System.out.println("anyMatch:" + list.stream().anyMatch(p)); // true neu co it nhat 1 phan tu khop voi predidate
        System.out.println("noneMatch:" + list.stream().noneMatch(p)); // true neu khong co phan tu nao khop voi predidate


        List<String> list2 = Arrays.asList("G","B","F","E");
        String any = list2.stream().findAny().get();
        System.out.println("FindAny: "+ any);
        String first = list2.stream().findFirst().get();
        System.out.println("FindFirst: "+ first);

        List<Integer> list3 = Arrays.asList(3,4,6,6,4);
        System.out.print("Distinct elements: ");
        list3.stream().distinct().forEach(x -> System.out.print(p + ", ")); // loai bo cac phan tu trung lap

        // map dung de chuyen doi tat ca cac doi tuong trong stream thanh 1 doi tuong khac theo dieu kien
        Stream<String> names = Stream.of("stack", "Java", "stackjava.com");
        System.out.println(names.map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList()));


        //max(): tìm phần tử có giá trị lớn nhất dựa theo Comparator.
        //min(): tìm phần tử có giá trị nhỏ nhất dựa theoComparator.
        List<String> list4 = Arrays.asList("G","B","F","E");
        String max = list4.stream().max(Comparator.comparing(String::valueOf)).get();
        System.out.println("Max:"+ max);
        String min = list4.stream().min(Comparator.comparing(String::valueOf)).get();
        System.out.println("Min:"+ min);

    }

}
