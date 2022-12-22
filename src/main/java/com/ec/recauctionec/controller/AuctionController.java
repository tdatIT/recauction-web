package com.ec.recauctionec.controller;

import com.ec.recauctionec.dto.AuctionSessionDTO;
import com.ec.recauctionec.entity.*;
import com.ec.recauctionec.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/dau-gia")
public class AuctionController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductTagService productTagService;
    @Autowired
    private AuctionService auctionService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuctSessJoinService joinService;


    @RequestMapping(value = "/tao-phien", method = RequestMethod.GET)
    public String getCreateAuction(ModelMap modelMap) {
        List<Category> categories = categoryService.findAll();
        List<ProductTag> tags = productTagService.findAll();
        modelMap.addAttribute("tags", tags);
        modelMap.addAttribute("categories", categories);
        return "user/create-auction";
    }

    @PostMapping(value = "/tao-phien")
    public ResponseEntity createAuction(@ModelAttribute AuctionSessionDTO dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User us = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        if (auctionService.createNewAuction(us, dto)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/quan-ly-phien")
    public String getAllAuctionOfUser(@RequestParam(value = "date-filter", required = false) Date date
            , ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User us = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        if (date == null)
            date = new Date(new java.util.Date().getTime());
        List<AuctionSession> data = auctionService.findAllByUserAndActive(us.getUserId(), date);
        modelMap.addAttribute("data", data);
        return "/user/all-auction";
    }

    @PostMapping(value = "/dat-gia-moi")
    public ResponseEntity getJoinAuction(@RequestParam("auctionId") int auctionId,
                                         @RequestParam("price") double price,
                                         ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User us = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        AuctionSession auction = auctionService.findById(auctionId);
        List<AuctSessJoin> joins = new ArrayList<>(auction.getAuctSessJoinsByAuctionSessId());
        for (AuctSessJoin j : joins) {
            if (j.getProductByProductId().getSupplierBySupplierId().getOwnerId() == us.getUserId()) {
                j.setPrice(price);
                joinService.updateJoin(j);
                return new ResponseEntity(HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}