package dk.vv.mtogo.product.msvc.pojos;

import dk.vv.common.data.transfer.objects.product.ProductDTO;
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

    // netto
    @Column(name = "net_price")
    private BigDecimal netPrice;

    // brutto
    @Column(name = "gross_price")
    private BigDecimal grossPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "supplier_id")
    private int supplierId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_stamp")
    private LocalDateTime createStamp;


    public void createGrossPrice(){
        if (this.netPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Net price must be zero or greater");
        }
        this.grossPrice = this.netPrice.multiply(BigDecimal.valueOf(1.25)).setScale(2,RoundingMode.HALF_UP);
    }

    public Product() {
    }

    public Product(ProductDTO productDTO) {
        this.productName = productDTO.getProductName();
        this.netPrice = productDTO.getGrossPrice();
        this.description = productDTO.getDescription();
        this.supplierId = productDTO.getSupplierId();
    }

    public ProductDTO toDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(getId());
        productDTO.setProductName(this.getProductName());
        productDTO.setNetPrice(this.getNetPrice());
        productDTO.setGrossPrice(this.getGrossPrice());
        productDTO.setDescription(this.getDescription());
        productDTO.setSupplierId(this.getSupplierId());
        return productDTO;
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

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal grossPrice) {
        this.netPrice = grossPrice;
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(BigDecimal netPrice) {
        this.grossPrice = netPrice;
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
