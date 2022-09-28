package de.atruvia.webappl.service.config;

import de.atruvia.webappl.repository.PersonenRepository;
import de.atruvia.webappl.service.PersonMapper;
import de.atruvia.webappl.service.PersonenService;
import de.atruvia.webappl.service.inner.PersonenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class PersonenConfig {

    @Bean
    @Primary
    public List<String> antipathen() {
        System.out.println("Hallo ###############");
        return List.of("Attila", "Peter","Paul","Mary");
    }

    @Bean
    public List<String> getFruit() {
        System.out.println("Hallo ###############");
        return List.of("Banana", "Cherry","Apple","Raspberry");
    }

//    @Bean // Spring loesstt die Parameter mit "Autowired" auf
//    public PersonenService getService(PersonenRepository repo, PersonMapper mapper, List<String> antipathen) {
//        return new PersonenServiceImpl(repo, mapper, antipathen);
//    }
}
