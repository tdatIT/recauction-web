package com.ec.recauctionec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String getPage403(ModelMap modelMap) {
        modelMap.addAttribute("message", "Lỗi 403");
        modelMap.addAttribute("description", "Tài khoản của bạn không có quyền truy cập " +
                "trang web này");
        return "message";
    }
}
