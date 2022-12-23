package com.ec.recauctionec.controller.supplier;

import com.ec.recauctionec.entity.CustomUserDetails;
import com.ec.recauctionec.entity.Supplier;
import com.ec.recauctionec.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/supplier")

public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = {"", "/dashboard"})
    public String getDashboard(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = ((CustomUserDetails) authentication.getPrincipal()).getUserId();
        Supplier sup = supplierService.findByOwnerId(userId);
        return "supplier/dashboard";
    }
}
