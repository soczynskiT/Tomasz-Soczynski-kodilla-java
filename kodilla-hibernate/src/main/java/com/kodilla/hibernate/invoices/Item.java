package com.kodilla.hibernate.invoices;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @NotNull
    @Column(name = "QUANTITY")
    private Integer quantity;


    @Column(name = "VALUE")
    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    public Item() {
    }

    public Item(BigDecimal price, Integer quantity) {
        this.price = price;
        this.quantity = quantity;
        this.value = calculateValue();
    }

    private BigDecimal calculateValue() {
        return BigDecimal.valueOf(quantity).multiply(price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
