package pl.mbanacho.corpo.database.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productlines")
public class Productline implements Serializable {

    @Id
    @Column(name = "productLine", updatable = false, nullable = false)
    private String productLine;

    private String textDescription;

    @Column(columnDefinition = "mediumtext")
    private String htmlDescription;

    @Column(columnDefinition = "mediumblob")
    private String image;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
