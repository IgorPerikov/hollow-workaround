package org.clayman.scoring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // TODO: 0.2 switch to some external scheduling solution
public class CalculatorApp {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApp.class, args);
    }
}
