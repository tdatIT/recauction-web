package com.ec.recauctionec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/chinh-sach-nguoi-dung")
    public String getBlog1(){
        return "blog";
    }
}
