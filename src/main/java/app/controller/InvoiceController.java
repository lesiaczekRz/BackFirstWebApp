package app.controller;

import app.model.Invoice;
import app.model.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    Invoice newInvoice(@RequestParam Invoice newInvoice) {
        return newInvoice;
    }
}
