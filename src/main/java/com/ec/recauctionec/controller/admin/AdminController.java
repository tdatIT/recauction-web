package com.ec.recauctionec.controller.admin;

import com.ec.recauctionec.entity.Product;
import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.repositories.UserRepo;
import com.ec.recauctionec.service.ProductService;
import com.ec.recauctionec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping(value = {""})
    public String getDashboard(ModelMap modelMap) {
        return "admin/dashboard";
    }
}
