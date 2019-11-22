package xyz.nandu.store_order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "OrderServiceError")
    public String OrderService(String name){
        return restTemplate.getForObject("http://Eureka-Client/hello?name="+name,String.class);
    }

    public String OrderServiceError(String name){
        return "hello" + name +",sorry,OrderService Error";
    }
}
