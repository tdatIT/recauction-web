package com.ec.recauctionec.controller;

import com.ec.recauctionec.entity.*;
import com.ec.recauctionec.repositories.UserAddressRepo;
import com.ec.recauctionec.repositories.WalletHistoryRepo;
import com.ec.recauctionec.repositories.WalletRepo;
import com.ec.recauctionec.service.SupplierService;
import com.ec.recauctionec.service.UserService;
import com.ec.recauctionec.variable.RoleConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/tai-khoan")
public class AccountController {
    @Autowired
    UserService userService;
    @Autowired
    UserAddressRepo addressRepo;
    @Autowired
    private WalletRepo walletRepo;
    @Autowired
    private WalletHistoryRepo historyRepo;
    @Autowired
    private SupplierService supplierService;


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

    @RequestMapping(value = {"/dang-ky-nha-cung-cap"}, method = RequestMethod.GET)
    public String viewRegisterSupp(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = ((CustomUserDetails) auth.getPrincipal()).getUser();
        modelMap.addAttribute("userId", user.getUserId());
        return "user/supplier-register";
    }

    @GetMapping(value = "/quan-ly-vi")
    public String getWalletPage(@RequestParam(value = "filter", required = false)
                                @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User us = ((CustomUserDetails) auth.getPrincipal()).getUser();
        Wallet wallet = walletRepo.findByUserId(us.getUserId()).get(0);
        WalletHistory recent = historyRepo.findTop1ByWalletOrderByCreateDateDesc(wallet);
        List<WalletHistory> logs = date == null ?
                historyRepo.findLogByDate(new Date(new Date().getTime()), wallet.getWalletId())
                : historyRepo.findLogByDate(date, wallet.getWalletId());
        modelMap.addAttribute("logs", logs);
        modelMap.addAttribute("recent", recent);
        modelMap.addAttribute("wallet", wallet);
        return "user/wallet-management";
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

    @RequestMapping(value = {"/dang-ky-nha-cung-cap"}, method = RequestMethod.POST)
    public String registerSupplier(@RequestParam("userId") int userId,
                                   @RequestParam("location") int location,
                                   ModelMap modelMap) {
        User us = userService.findById(userId);
        if (us != null) {
            supplierService.insertNewSupplier(userId, location);
            return "redirect:/dang-xuat";
        }
        return "redirect:/thong-bao?type=3";

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
