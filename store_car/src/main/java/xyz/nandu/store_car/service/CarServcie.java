package xyz.nandu.store_car.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarServcie {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "CarServiceError")
    public String CarService(String name){
        return restTemplate.getForObject("http://Eureka-Client/hello?name="+name,String.class);
    }

    public String CarServiceError(String name){
        return "hello" + name +",sorry,CarService Error";
    }
}
