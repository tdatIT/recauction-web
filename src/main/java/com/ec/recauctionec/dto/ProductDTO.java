package com.ec.recauctionec.dto;

import com.ec.recauctionec.entity.Product;
import com.ec.recauctionec.entity.ProductImg;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Getter
@Setter
@Data
public class ProductDTO {

    private int productId;

    private int categoryId;

    private String detail;

    private String productName;

    private int status;

    private double defaultPrice;

    private double minPrice;

    private int supplierId;
    private String productTag;

    private MultipartFile[] images_file;

    private Collection<ProductImg> images;
    private boolean isDeleted;

    public Product mapping() {
        Product p = new Product();
        BeanUtils.copyProperties(this, p);
        return p;
    }
}
