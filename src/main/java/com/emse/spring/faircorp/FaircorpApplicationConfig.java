package com.emse.spring.faircorp;

import org.springframework.boot.CommandLineRunner;

public class FaircorpApplicationConfig {

    public CommandLineRunner greetingCommandLine() { // (3)
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // (4)
            }
        };
    }
}
