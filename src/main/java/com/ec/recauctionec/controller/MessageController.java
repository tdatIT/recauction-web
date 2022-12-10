package com.ec.recauctionec.controller;

import com.ec.recauctionec.variable.Router;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class MessageController {
    @GetMapping(value = Router.MESSAGE)
    public String getMessage(@RequestParam("type") int type, ModelMap modelMap) {
        switch (type) {
            case 1:
                modelMap.addAttribute("message", "Đặt yêu cầu đổi mật khẩu thành công");
                modelMap.addAttribute("description", "Vui lòng kiểm tra email để xác nhận");
                break;
        }
        return "message";
    }
}
