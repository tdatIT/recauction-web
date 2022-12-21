package com.ec.recauctionec.controller;

import com.ec.recauctionec.entity.CustomUserDetails;
import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.entity.UserAddress;
import com.ec.recauctionec.repositories.UserAddressRepo;
import com.ec.recauctionec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/tai-khoan")
public class AccountController {
    @Autowired
    UserService userService;
    @Autowired
    UserAddressRepo addressRepo;

    @RequestMapping(value = {"/thong-tin", ""}, method = RequestMethod.GET)
    public String viewInfo(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.findByEmail(email);
        if (user != null) {
            modelMap.addAttribute("user", user);
            return "info";
        } else {
            return "redirect:/dang-nhap";
        }
    }

    @RequestMapping(value = {"/chinh-sua"}, method = RequestMethod.GET)
    public String viewUpdate(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = ((CustomUserDetails) auth.getPrincipal()).getUser();
        modelMap.addAttribute("user", user);
        return "user/update-info";
    }

    @PostMapping(value = "/them-dia-chi")
    public String addAddress(@ModelAttribute UserAddress address,
                             ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = ((CustomUserDetails) auth.getPrincipal()).getUser();
        address.setUserByUserId(user);
        addressRepo.save(address);
        return "redirect:/tai-khoan";
    }

    @PostMapping(value = "/doi-mat-khau")
    public String updatePassword(@RequestParam("current-password") String curr_passwd,
                                 @RequestParam("password") String newPass,
                                 ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User us = ((CustomUserDetails) auth.getPrincipal()).getUser();
        return userService.updatePassword(us, curr_passwd, newPass) ?
                "redirect:/tai-khoan" :
                "redirect:/tai-khoan/chinh-sua?error=2";
    }

    @PostMapping(value = "/doi-thong-tin")
    public String updateInfo(@RequestParam("firstname") String firstname,
                             @RequestParam("lastname") String lastname,
                             @RequestParam("email") String email,
                             @RequestParam("phone") String phone,
                             ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User us = ((CustomUserDetails) auth.getPrincipal()).getUser();
        try {
            us.setFirstName(firstname);
            us.setLastName(lastname);
            us.setEmail(email);
            us.setPhoneNumber(phone);
            userService.updateUser(us);
            return "redirect:/tai-khoan ";
        } catch (Exception e) {
            return "redirect:/tai-khoan/chinh-sua?error=1";
        }

    }


}
