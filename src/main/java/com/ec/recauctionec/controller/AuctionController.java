package com.ec.recauctionec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/dau-gia")
public class AuctionController {
    @RequestMapping(value = "/tao-phien", method = RequestMethod.GET)
    public String getCreateAuction(ModelMap modelMap) {
        return "create-auction";
    }

}
