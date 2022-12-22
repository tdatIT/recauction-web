package com.ec.recauctionec.controller;

import com.ec.recauctionec.entity.AuctionSession;
import com.ec.recauctionec.entity.Product;
import com.ec.recauctionec.service.AuctionService;
import com.ec.recauctionec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "chi-tiet-san-pham")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private AuctionService auctionService;

    @RequestMapping("/supp-view/{id}")
    public String viewProductSupplier(@PathVariable int id, ModelMap modelMap) {
        List<AuctionSession> top10Auction = auctionService.findTop10AuctionForDay();
        modelMap.addAttribute("top10Auction", top10Auction);
        Product p = productService.findById(id);
        if (p.getProductId() != 0) {
            modelMap.addAttribute("product", p);
            return "product-suppview";
        }
        return "redirect:/404";
    }
}
