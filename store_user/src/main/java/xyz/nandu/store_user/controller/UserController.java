package xyz.nandu.store_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.nandu.store_user.service.UserService;

@RestController

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index.page")
    public String indexPage(@RequestParam String name){
        return userService.UserService(name);
    }
}
