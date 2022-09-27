package de.atruvia.first.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Demo {


    private final Translator translator; // Zweiter  Schritt bei der Erzeugung durch Spring

    private String message = "Hier ist Demo";

    //@Autowired
    // Erster Schritt bei der Erzeugung durch Spring
    public Demo(/*@Qualifier("upper")*/ final Translator translator, @Value("${Demo.anna}") String message) {
        this.message =message;
        this.translator = translator;
        System.out.println(translator.translate("Ctor Demo"));
        System.out.println(translator.translate( "Ctor: " + message));
    }

    @PostConstruct
    public void fritz() { // Dritter  Schritt bei der Erzeugung durch Spring
        System.out.println(translator.translate("Fritz"));
    }

    public void ausgabe() {
        System.out.println(translator.translate( "Ausgabe: " + message));
    }

    @PreDestroy
    public void dispose() {
        System.out.println("und tschuess");
    }
}
