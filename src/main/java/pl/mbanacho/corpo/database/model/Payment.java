package pl.mbanacho.corpo.database.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment implements Serializable {


    //composite key
    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerNumber", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Customer customerNumber;

    @Id
    @Column(columnDefinition = "varchar(50)", updatable = false, nullable = false)
    private String checkNumber;

    @Column(columnDefinition = "date", nullable = false)
    private LocalDate paymentDate;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double amount;

    public Customer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Customer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
