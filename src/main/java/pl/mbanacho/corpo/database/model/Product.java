package pl.mbanacho.corpo.database.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String productCode;

    @Column(columnDefinition = "varchar(70)", nullable = false)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productLine", nullable = false, insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Productline productLine;

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String productScale;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String productVendor;

    @Column(columnDefinition = "text", nullable = false)
    private String productDescription;

    @Column(columnDefinition = "smallint(6)", nullable = false)
    private Integer quantityInStock;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double buyPrice;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double MSRP;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Productline getProductLine() {
        return productLine;
    }

    public void setProductLine(Productline productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getMSRP() {
        return MSRP;
    }

    public void setMSRP(Double MSRP) {
        this.MSRP = MSRP;
    }
}
