package com.ec.recauctionec.controller;

import com.ec.recauctionec.dto.AuctionSessionDTO;
import com.ec.recauctionec.entity.*;
import com.ec.recauctionec.service.AuctionService;
import com.ec.recauctionec.service.CategoryService;
import com.ec.recauctionec.service.ProductTagService;
import com.ec.recauctionec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
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


    @RequestMapping(value = "/tao-phien", method = RequestMethod.GET)
    public String getCreateAuction(ModelMap modelMap) {
        List<Category> categories = categoryService.findAll();
        List<ProductTag> tags = productTagService.findAll();
        modelMap.addAttribute("tags", tags);
        modelMap.addAttribute("categories", categories);
        return "user/create-auction";
    }

    @PostMapping(value = "/tao-phien")
    public String createAuction(@Valid @ModelAttribute AuctionSessionDTO dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User us = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        if (auctionService.createNewAuction(us, dto)) {
            return "redirect:/";
        }
        return "redirect:/404";
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
}