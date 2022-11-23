package com.ec.recauctionec.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Categories {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "category_name", nullable = false, length = 255)
    private String categoryName;
    @Basic
    @Column(name = "detail", nullable = true, length = 255)
    private String detail;
    @Basic
    @Column(name = "image", nullable = true, length = 255)
    private String image;

    @OneToMany(mappedBy = "categoriesByCategoryId")
    private Collection<Products> productsByCategoryId;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return categoryId == that.categoryId && Objects.equals(categoryName, that.categoryName) && Objects.equals(detail, that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, detail);
    }

    public Collection<Products> getProductsByCategoryId() {
        return productsByCategoryId;
    }

    public void setProductsByCategoryId(Collection<Products> productsByCategoryId) {
        this.productsByCategoryId = productsByCategoryId;
    }
}
