package com.ec.recauctionec.controller;

import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/tai-khoan")
public class AccountController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/thong-tin","/"}, method = RequestMethod.GET)
    public String viewInfo(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.findByEmail(email);
        if (user != null) {
            modelMap.addAttribute("user", user);
            return "info";
        } else {
            return "redirect:/login";
        }
    }


}
