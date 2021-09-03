package app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.TimeZone;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    UserRepository userRepository;

    @Bean
    CommandLineRunner initDatabase() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return args -> {
            log.info("Preloading " + userRepository.save(new User(1L, "Test1")));
            log.info("Preloading " + userRepository.save(new User(2L, "Test2")));

            log.info("Preloading " + invoiceRepository.save(new Invoice("1/2021", 10.50f,
                    LocalDateTime.parse("2021-08-02T00:00"), userRepository.getById(1L))));

//            log.info("Preloading " + invoiceRepository.save(new Invoice("2/2021", 1100.00f,
//                    LocalDateTime.parse("2021-08-01T00:00"), userRepository.findById(2L))));
        };
    }

}
