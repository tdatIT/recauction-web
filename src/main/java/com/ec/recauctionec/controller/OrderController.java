package com.ec.recauctionec.controller;

import com.ec.recauctionec.dto.OrderDTO;
import com.ec.recauctionec.entity.CustomUserDetails;
import com.ec.recauctionec.entity.Orders;
import com.ec.recauctionec.entity.User;
import com.ec.recauctionec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/don-hang")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public String getOrderList(@RequestParam(value = "filter", required = false)
                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                               ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        List<Orders> orders = date == null ?
                orderService.findOrderByDate(user.getUserId(), new Date(new Date().getTime()))
                : orderService.findOrderByDate(user.getUserId(), date);
        modelMap.addAttribute("orders", orders);
        return "user/order-list";
    }
    @GetMapping("/xac-nha-don-hang/{id}")
    public String getConfirmOrder(@PathVariable("id")int orderId,ModelMap modelMap){
        Orders orders = orderService.findById(orderId);
        if(orders != null){

        }
        return "";
    }

}
