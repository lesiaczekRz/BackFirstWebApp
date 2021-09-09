package app.model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "user_invoice")
@Entity
public class UserInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    UserInvoice() {

    }

    public UserInvoice(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInvoice userInvoice = (UserInvoice) o;
        return id.equals(userInvoice.id) && name.equals(userInvoice.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "UserInvoice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}