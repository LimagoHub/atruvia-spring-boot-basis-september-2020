package de.atruvia.first.demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("upper")
@Profile("development")
public class ToUpperTranslator implements Translator{
    @Override
    public String translate(String message) {
        return message.toUpperCase();
    }
}
