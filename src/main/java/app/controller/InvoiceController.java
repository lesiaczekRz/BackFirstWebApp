package app.controller;

import app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@CrossOrigin(origins = "http://localhost")
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
                .orElseThrow(() -> new InvoiceNotFoundException(id));
    }

    @PostMapping("/invoices")
    Invoice newInvoice(@RequestBody Invoice newInvoice) {
        newInvoice.setNumberInvoice(new InvoiceNumbering(repository).getNextNumberInvoice());
        return repository.save(newInvoice);
    }

    @DeleteMapping("/invoices/{id}")
    void deleteInvoice(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/invoices/{id}")
    Invoice replaceInvoice(@RequestBody Invoice newInvoice, @PathVariable Long id) {
        return repository.findById(id)
                .map(invoice -> {
                    invoice.setAmount(newInvoice.getAmount());
                    return repository.save(invoice);
                })
                .orElseThrow(() -> new InvoiceNotFoundException(id));
    }
}
