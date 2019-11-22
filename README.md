# Shoes_Stroe 
本项目是课程的期末考察作业，老师让使用Spring Cloud搭建一个鞋类商城的微服务构架，只是课程作业，需要的同学可以拿去！

## 项目结构说明
- eureka_server 注册中心
- eureka_client 客户端
- service_zuul 网关
- store_order 订单服务
- store_user 用户服务
- store_car 购物车服务

## 各模块使用说明
### eureka_server
- 端口：8761
直接运行，浏览器访问 localhost:8761 即可

### eureka_client
- 端口：8762\8763
需要更改服务端口号，多实例启动,建议启动两个
---
### service_zuul
- 端口：8769
网关服务，启动即可
#### 功能验证
- 启动 eureka_server
- 启动两个 eureka_client
- 启动 service_zuul
- 启动 store_user\car\order三个服务
- 浏览器依次访问
    - http://localhost:8769/order/index.page?name=nandu
    - http://localhost:8769/user/index.page?name=nandu
    - http://localhost:8769/car/index.page?name=nandu
- 浏览器显示 hello nandu ,port:8763(8762)
- 网关服务验证成功
---
### store_user  [ribbon(负载均衡)\Hystrix(熔断)]
- 端口：8764

#### 功能验证
- 启动 eureka_server
- 启动两个 eureka_client
- 启动 store_user
    - ribbon
        - 浏览器输入 localhost:8764/index.page?name=nandu
        - 浏览器依次显示 hello nandu ,port:8762\hello nandu ,port:8763
        - 负载均衡验证成功
    - Hystrix
        - 关闭已经启动的client
        - 浏览器访问 localhost:8764/index.page?name=nandu
        - hello，nandu,sorry,UserService Error
        - 熔断验证成功
---

### store_order  [ribbon(负载均衡)\Hystrix(熔断)]
- 端口：8765

#### 功能验证
- 启动 eureka_server
- 启动两个 eureka_client
- 启动 store_order
    - ribbon
        - 浏览器访问 localhost:8765/index.page?name=nandu
        - 浏览器依次显示 hello nandu ,port:8762\hello nandu ,port:8763
        - 负载均衡验证成功
    - Hystrix
        - 关闭已经启动的client
        - 浏览器访问 localhost:8765index.page?name=nandu
        - hello，nandu,sorry,OrderService Error
        - 熔断验证成功
---

### store_car  [ribbon(负载均衡)\Hystrix(熔断)]
- 端口：8766

#### 功能验证
- 启动 eureka_server
- 启动两个 eureka_client
- 启动 store_car
    - ribbon
        - 浏览器访问 localhost:8766/index.page?name=nandu
        - 浏览器依次显示 hello nandu ,port:8762\hello nandu ,port:8763
        - 负载均衡验证成功
    - Hystrix
        - 关闭已经启动的client
        - 浏览器访问 localhost:8766/index.page?name=nandu
        - hello，nandu,sorry,CarService Error
        - 熔断验证成功
---
## 总结
- 本项目只是搭建构建，没有实现具体功能
- 使用的版本是Spring Boot 2.0.3.RELEASE\Spring Cloud Finchley.RELEASE 注意版本对应
