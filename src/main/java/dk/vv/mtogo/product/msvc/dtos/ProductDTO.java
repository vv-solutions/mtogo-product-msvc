package dk.vv.mtogo.product.msvc.dtos;

import dk.vv.mtogo.product.msvc.pojos.Product;

import java.math.BigDecimal;

public class ProductDTO {

    private int id;

    private String name;

    // Pre vat
    private BigDecimal grossPrice;

    // Post vat
    private BigDecimal netPrice;

    private String description;

    private int supplierId;


    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.grossPrice = product.getGrossPrice();
        this.netPrice = product.getNetPrice();
        this.description = product.getDescription();
        this.supplierId = product.getSupplierId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
