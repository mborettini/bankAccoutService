package entity.people;

import entity.items.CreditCard;

import java.time.LocalDate;
import java.util.Objects;

public class Client extends Human {

    private final Long id;
    private Float accountState;
    private CreditCard creditCard;

    public Client(Long id, Float accountState, Long nrPESEL, String firstName, String middleName, String lastName, LocalDate dateOfBirth, String email, Long phone, String city, String street, String postalCode, CreditCard creditCard) {
        super(nrPESEL, firstName, middleName, lastName, dateOfBirth, email, phone, city, street, postalCode);
        this.id = id;
        this.accountState = accountState;
        this.creditCard = creditCard;
    }

    public Long getId() {
        return id;
    }

    public Float getAccountState() {
        return accountState;
    }

    public void setAccountState(Float accountState) {
        this.accountState = accountState;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Numer klienta: " + id +
                ", stan konta: " + accountState +
                " PLN, nrPESEL: " + getNrPESEL() +
                ", Imię: '" + getFirstName() + '\'' +
                ", Drugie imię: '" + getMiddleName() + '\'' +
                ", Nazwisko: '" + getLastName() + '\'' +
                ", Data urodzenia: " + getDateOfBirth() +
                ", E-mail: '" + getEmail() + '\'' +
                ", Telefon: " + getPhone() +
                ", Miasto: '" + getCity() + '\'' +
                ", Adres: '" + getStreet() + '\'' +
                ", Kod pocztowy: '" + getPostalCode() + '\'' +
                '.';
    }
}
