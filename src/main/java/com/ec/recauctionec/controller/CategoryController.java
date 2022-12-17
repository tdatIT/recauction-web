package com.ec.recauctionec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping(value = "/doanh-muc-san-pham")
public class CategoryController {
    @RequestMapping(value = {"", "/{id}"}, method = RequestMethod.GET)
    public String getProduct(@PathVariable(required = false) int id,
                             ModelMap modelMap) {
        return "category-view";
    }
}
