package pl.mbanacho.corpo.database.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    private Integer customerNumber;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String customerName;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String contactLastName;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String contactFirstName;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String phone;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String addressLine1;

    @Column(columnDefinition = "varchar(50)")
    private String addressLine2;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String city;

    @Column(columnDefinition = "varchar(50)")
    private String state;

    @Column(columnDefinition = "varchar(15)")
    private String postalCode;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String country;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salesRepEmployeeNumber", nullable = false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Employee salesRepEmployeeNumber;

    @Column(columnDefinition = "decimal(10,2)")
    private Double creditLimit;

    public Integer getOrderNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(Employee salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
