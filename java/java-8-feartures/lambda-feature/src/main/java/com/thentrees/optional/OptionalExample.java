package com.thentrees.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        String[] str = new String[10];
//        System.out.println(lowerCase);

        Optional<String> checkNull = Optional.ofNullable(str[4]);
        if(checkNull.isPresent()){
            String lowerCase = str[4].toLowerCase();
            System.out.println(lowerCase);
        }else{
            System.out.println("String is null");
        }

        Optional<User> userEmpty = Optional.empty();
        if(userEmpty.isPresent())
            System.out.println(userEmpty.get().getName());
        else
            System.out.println("User is empty");

        User user2 = new User(2, "John");
        Optional<User> userOptional = Optional.of(user2);
        if(userOptional.isPresent())
            System.out.println(userOptional.get().getName());
        else
            System.out.println("User is empty");

        userEmpty.ifPresent(user -> {
                userEmpty.orElse(new User(3, "Jane"));
                System.out.println("User is empty -> switch to Jane");
        });
    }


}