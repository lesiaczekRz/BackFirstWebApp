package app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(InvoiceRepository repository) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return args -> {
            log.info("Preloading " + repository.save(new Invoice("1/2021", 10.50f,
                    LocalDateTime.parse("2021-08-02T00:00"))));
            log.info("Preloading " + repository.save(new Invoice("2/2021", 1100.00f,
                    LocalDateTime.parse("2021-08-01T00:00"))));
        };
    }

}
