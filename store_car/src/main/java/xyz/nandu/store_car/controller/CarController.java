package xyz.nandu.store_car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.nandu.store_car.service.CarServcie;

@RestController
public class CarController {

    @Autowired
    CarServcie carServcie;

    @RequestMapping("/index.page")
    public String indexPage(@RequestParam String name){
        return carServcie.CarService(name);
    }

}
