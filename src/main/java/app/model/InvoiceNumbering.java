package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class InvoiceNumbering {

    private final InvoiceRepository repository;

    @Autowired
    public InvoiceNumbering(InvoiceRepository repository) {
        this.repository = repository;
    }

    /**
     * Pobiera następny numer faktury
     *
     * @return String|null
     */
    public String getNextNumberInvoice() {
        String lastNumber = repository.getLastNumberVoice();
        int n;
        if (lastNumber == null) {
            lastNumber = "0/0";
        }
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        String[] arrayNumber = lastNumber.split("/");
        if (year.equals(arrayNumber[1])) {
            n = Integer.parseInt(arrayNumber[0]) + 1;
        } else {
            n = 1;
        }
        return n + "/" + year;
    }
}
