package com.ec.recauctionec.controller.supplier;

import com.ec.recauctionec.dto.ProductDTO;
import com.ec.recauctionec.entity.*;
import com.ec.recauctionec.service.CategoryService;
import com.ec.recauctionec.service.ProductService;
import com.ec.recauctionec.service.StorageImage;
import com.ec.recauctionec.service.SupplierService;
import com.ec.recauctionec.variable.SupplierLevel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/supplier/san-pham")
public class SProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    StorageImage storageImage;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getProductList(ModelMap modelMap, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getUserId();
        Supplier sup = supplierService.findByOwnerId(userId);
        int supplierId = sup.getSupplierId();
        List<Product> products = productService.findBySupplierId(supplierId);
        if (SupplierLevel.checkingAvailableProduct(sup)) {
            int available = SupplierLevel.getNumberProductAvailable(sup.getLevelSupp()) - products.size();
            modelMap.addAttribute("message", "Bạn thể thêm  [" + available
                    + "] sản phẩm");
        }
        modelMap.addAttribute("products", products);
        return "supplier/store-product";
    }

    @RequestMapping(value = "/them", method = RequestMethod.GET)
    public String getInsertProduct(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getUserId();
        Supplier sup = supplierService.findByOwnerId(userId);
        if (SupplierLevel.checkingAvailableProduct(sup)) {
            List<Category> categories = categoryService.findAll();
            ProductDTO productDTO = new ProductDTO();

            modelMap.addAttribute("categories", categories);
            modelMap.addAttribute("productDTO", productDTO);
            modelMap.addAttribute("action", "them");

            return "supplier/product-info";
        }
        return "forward:/supplier/san-pham";
    }


    @Transactional
    @RequestMapping(value = "/them", method = RequestMethod.POST)
    public String insertNewProduct(@ModelAttribute ProductDTO productDTO,
                                   ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getUserId();
        Supplier sup = supplierService.findByOwnerId(userId);
        if (SupplierLevel.checkingAvailableProduct(sup)) {
            int supplierId = sup.getSupplierId();
            Product product = productDTO.mapping();
            product.setSupplierId(supplierId);
            List<ProductImg> imgs = new ArrayList<>();
            List<String> filenames = storageImage.storageMultiImage(productDTO.getImages_file());
            for (String name : filenames) {
                ProductImg img = new ProductImg();
                img.setImgName(name);
                img.setProduct(product);
                imgs.add(img);
            }
            product.setImages(imgs);
            productService.insertProduct(product);
        }
        return "redirect:/supplier/san-pham";

    }


    @RequestMapping(value = "/chinh-sua/{id}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable int id, ModelMap modelMap) {

        List<Category> categories = categoryService.findAll();
        Product p = productService.findById(id);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(p, productDTO);
        modelMap.addAttribute("action", "/supplier/san-pham/chinh-sua");
        modelMap.addAttribute("productDTO", productDTO);
        modelMap.addAttribute("categories", categories);
        return "supplier/product-info";
    }

    @Transactional
    @RequestMapping(value = "/chinh-sua", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute ProductDTO productDTO
            , ModelMap modelMap) {

        Product p = productService.findById(productDTO.getProductId());
        p.setProductName(productDTO.getProductName());
        p.setStatus(productDTO.getStatus());
        p.setCategoryId(productDTO.getCategoryId());
        p.setDefaultPrice(productDTO.getDefaultPrice());
        p.setMinPrice(productDTO.getMinPrice());
        p.setDetail(productDTO.getDetail());

        if (productDTO.getImages_file() != null) {
            List<ProductImg> imgs = new ArrayList<>();
            List<String> filenames = storageImage.storageMultiImage(productDTO.getImages_file());
            for (String name : filenames) {
                ProductImg img = new ProductImg();
                img.setImgName(name);
                img.setProduct(p);
                imgs.add(img);
            }
            p.setImages(imgs);
        }

        productService.updateProduct(p);
        return "redirect:/supplier/san-pham";
    }

    @RequestMapping(value = "/xoa/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id, ModelMap modelMap) {
        Product p = productService.findById(id);
        productService.deleteProduct(p);
        return "redirect:/supplier/san-pham";
    }

}
