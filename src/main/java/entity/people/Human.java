package entity.people;

import java.time.LocalDate;

public class Human {

    private Long nrPESEL;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private Long phone;
    private String city;
    private String street;
    private String postalCode;

    public Human(Long nrPESEL, String firstName, String middleName, String lastName, LocalDate dateOfBirth, String email, Long phone, String city, String street, String postalCode) {
        this.nrPESEL = nrPESEL;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public Human() {

    }

    public Long getNrPESEL() {
        return nrPESEL;
    }

    public void setNrPESEL(Long nrPESEL) {
        this.nrPESEL = nrPESEL;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "nrPESEL: " + nrPESEL +
                ", Imię: '" + firstName + '\'' +
                ", Drugie imię: '" + middleName + '\'' +
                ", Nazwisko: '" + lastName + '\'' +
                ", Data urodzenia: " + dateOfBirth +
                ", E-mail: '" + email + '\'' +
                ", Telefon: " + phone +
                ", Miasto: '" + city + '\'' +
                ", Adres: '" + street + '\'' +
                ", Kod pocztowy: '" + postalCode + '\'' +
                '.';
    }
}
