package xyz.nandu.store_user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "UserServiceError")
    public String UserService(String name){
        return restTemplate.getForObject("http://Eureka-Client/hello?name="+name,String.class);
    }

    public String UserServiceError(String name){
        return "hello" + name +",sorry,UserService Error";
    }
}
