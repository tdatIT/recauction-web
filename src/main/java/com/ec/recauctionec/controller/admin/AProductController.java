package com.ec.recauctionec.controller.admin;

import com.ec.recauctionec.dto.ProductDTO;
import com.ec.recauctionec.entity.Category;
import com.ec.recauctionec.entity.Product;
import com.ec.recauctionec.entity.ProductImg;
import com.ec.recauctionec.service.CategoryService;
import com.ec.recauctionec.service.ProductService;
import com.ec.recauctionec.service.StorageImage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/san-pham")
public class AProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    StorageImage storageImage;

    @GetMapping(value = {""})
    public String getProductList(ModelMap modelMap, HttpServletRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Product> productList = productService.findAllProduct();
        modelMap.addAttribute("productList", productList);
        return "admin/admin-product";
    }

    @RequestMapping(value = "/chinh-sua/{id}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable int id, ModelMap modelMap) {

        List<Category> categories = categoryService.findAll();
        Product p = productService.findById(id);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(p, productDTO);
        modelMap.addAttribute("action", "/admin/san-pham/chinh-sua");
        modelMap.addAttribute("productDTO", productDTO);
        modelMap.addAttribute("categories", categories);
        return "/admin/product-info";
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
        return "redirect:/admin/san-pham";
    }

    @RequestMapping(value = "/xoa/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id, ModelMap modelMap) {
        Product p = productService.findById(id);
        productService.deleteProduct(p);
        return "redirect:/admin/san-pham";
    }

}
