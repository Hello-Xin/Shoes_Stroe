package xyz.nandu.store_order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.nandu.store_order.service.OrderService;

@RestController

public class OrederController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/index.page")
    public String indexPage(@RequestParam String name){
        return orderService.OrderService(name);
    }
}
