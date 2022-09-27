package de.atruvia.first;

import de.atruvia.first.demo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AlternativesMain implements CommandLineRunner {

    @Autowired
    private Demo demo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hallo Universum!");
        demo.ausgabe();
        System.out.println(demo);
    }
}
