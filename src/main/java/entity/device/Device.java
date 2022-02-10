package entity.device;

import java.util.Objects;

public class Device {

    private final Long number;
    private String city;
    private String street;
    private String postalCode;

    public Device(Long number, String city, String street, String postalCode) {
        this.number = number;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public Long getNumber() {
        return number;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return number.equals(device.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Numer urządzenia:" + number +
                ", miasto:'" + city + '\'' +
                ", ulica:'" + street + '\'' +
                ", kod pocztowy:'" + postalCode + '\'' +
                '.';
    }
}
