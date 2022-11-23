package com.ec.recauctionec.controller;

import com.ec.recauctionec.entity.Users;
import com.ec.recauctionec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(ModelMap modelMap) {
        return "index";
    }


    //get page sign up
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            Users user = new Users();
            modelMap.addAttribute("registerAcc", user);
            return "register";
        } else
            return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewAccount(@ModelAttribute Users register, ModelMap modelMap) {
        try {
            userService.registerAccount(register);
            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register?error=true";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }
}
