package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DummyUserService implements UserService {
    @Autowired
    private GreetingService gService;
    @Override
    public void greetAll(){
        List<String> list = Arrays. asList("Elodie", "Charles");//list of String.
        for (int i=0;i< list.size();i++){
            gService.greet(list.get(i));//call greet method of the GreetingService
        }

        //System.out.println("hi , all");
    }

    //@Autowired
//    public DummyUserService(GreetingService gService) {
//        this.gService = gService;
//    }

}
