package app.controller;

import app.model.Invoice;
import app.model.InvoiceNumbering;
import app.model.InvoiceRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
public class InvoiceController {

    @Autowired
    InvoiceRepository repository;

    @GetMapping("/invoices")
    List<Invoice> all() {
        return repository.findAll();
    }

    @GetMapping("/invoices/{id}")
    Invoice one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    @PostMapping("/invoices")
    @NotNull
    Invoice newInvoice(@RequestBody Invoice newInvoice) {
        newInvoice.setNumberInvoice(new InvoiceNumbering(repository).getNextNumberInvoice());
        return repository.save(newInvoice);
    }
}
