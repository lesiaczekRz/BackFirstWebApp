package app.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Table(name = "invoice")
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,unique=true)
    private String numberInvoice;

    @Column(nullable = false)
    private Float amount;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    private UserInvoice userInvoice;

    Invoice() {
        setDate(null);
    }

    public Invoice(String numberInvoice, Float amount, LocalDateTime date, UserInvoice userInvoice) {
        setNumberInvoice(numberInvoice);
        setAmount(amount);
        setDate(date);
        setUser(userInvoice);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = Objects.requireNonNullElseGet(date, () -> LocalDateTime.now(ZoneId.of("Europe/Warsaw")));
    }

    public String getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public UserInvoice getUser() {
        return userInvoice;
    }

    public void setUser(UserInvoice userInvoice) {
        this.userInvoice = userInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id.equals(invoice.id) && numberInvoice.equals(invoice.numberInvoice) && amount.equals(invoice.amount)
                && date.equals(invoice.date) && userInvoice.equals(invoice.userInvoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberInvoice, amount, date, userInvoice);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", numberInvoice='" + numberInvoice + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", userInvoice=" + userInvoice +
                '}';
    }
}
