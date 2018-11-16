package pl.mbanacho.corpo.database.model;

import javax.persistence.*;

@Entity
@Table(name = "offices")
public class Office {

    @Id
    @Column(name = "officeCode", nullable = false)
    private String officeCode;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String city;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String phone;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String addressLine1;

    @Column(columnDefinition = "varchar(50)")
    private String addressLine2;

    @Column(columnDefinition = "varchar(50)")
    private String state;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String country;

    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String postalCode;

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String territory;

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }
}
