package dk.vv.mtogo.product.msvc.pojos;


import dk.vv.mtogo.product.msvc.dtos.ProductDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    // pre vat
    @Column(name = "gross_price")
    private BigDecimal grossPrice;

    // Post vat
    @Column(name = "net_price")
    private BigDecimal netPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "supplier_id")
    private int supplierId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_stamp")
    private LocalDateTime createStamp;


    public void createNetPrice(){
        if (this.grossPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Gross price must be zero or greater");
        }
        this.netPrice = this.grossPrice.multiply(BigDecimal.valueOf(1.25)).setScale(2,RoundingMode.HALF_UP);
    }

    public Product() {
    }

    public Product(ProductDTO productDTO) {
        this.productName = productDTO.getProductName();
        this.grossPrice = productDTO.getGrossPrice();
        this.description = productDTO.getDescription();
        this.supplierId = productDTO.getSupplierId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(BigDecimal grossPrice) {
        this.grossPrice = grossPrice;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public LocalDateTime getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(LocalDateTime createStamp) {
        this.createStamp = createStamp;
    }


}
