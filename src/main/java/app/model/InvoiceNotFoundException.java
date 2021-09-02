package app.model;

public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(Long id) {
        super("Nie znaleziono faktury o id: " + id);
    }
}
