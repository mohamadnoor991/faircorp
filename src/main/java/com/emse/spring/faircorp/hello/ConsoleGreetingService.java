package com.emse.spring.faircorp.hello;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class ConsoleGreetingService  implements GreetingService{
    @Override

    public void greet(String name){
        System.out.println("hello ,"+name+"!");

    }
//    @Primary
//    public void greet1(String name){
//        System.out.println("bonjour ,"+name+"!");
//
//    }
}
