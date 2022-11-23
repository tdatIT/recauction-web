package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;
    @Basic
    @Column(name = "detail", nullable = true, length = 255)
    private String detail;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "supplier_id", nullable = false)
    private int supplierId;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<AuctionSessions> auctionSessionsByProductId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false,insertable = false,updatable = false)
    private Categories categoriesByCategoryId;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id", nullable = false,insertable = false,updatable = false)
    private Suppliers suppliersBySupplierId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return productId == products.productId && categoryId == products.categoryId && supplierId == products.supplierId && Objects.equals(productName, products.productName) && Objects.equals(detail, products.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, detail, categoryId, supplierId);
    }

    public Collection<AuctionSessions> getAuctionSessionsByProductId() {
        return auctionSessionsByProductId;
    }

    public void setAuctionSessionsByProductId(Collection<AuctionSessions> auctionSessionsByProductId) {
        this.auctionSessionsByProductId = auctionSessionsByProductId;
    }

    public Categories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Categories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    public Suppliers getSuppliersBySupplierId() {
        return suppliersBySupplierId;
    }

    public void setSuppliersBySupplierId(Suppliers suppliersBySupplierId) {
        this.suppliersBySupplierId = suppliersBySupplierId;
    }
}
