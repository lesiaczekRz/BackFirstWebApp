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
    UserInvoiceRepository userInvoiceRepository;

//    @Bean
//    CommandLineRunner initDatabase() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//        UserInvoice userInvoice1 = userInvoiceRepository.save(new UserInvoice("Test1"));
//        UserInvoice userInvoice2 = userInvoiceRepository.save(new UserInvoice("Test2"));
//        return args -> {
//            log.info("Preloading " + userInvoice1.toString());
//            log.info("Preloading " + userInvoice2.toString());
//
//            log.info("Preloading " + invoiceRepository.save(new Invoice("1/2021", 10.50f,
//                    LocalDateTime.parse("2021-08-02T00:00"), userInvoice1)));
//
//            log.info("Preloading " + invoiceRepository.save(new Invoice("2/2021", 1100.00f,
//                    LocalDateTime.parse("2021-08-01T00:00"), userInvoice2)));
//        };
//    }

}
