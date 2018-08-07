package com.zn.test.ribbon.web;

import com.zn.test.ribbon.servce.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    private HelloService helloService;

    /**
     * 一个服务注册中心，eureka server,端口为8761;
     * service-hi工程跑了两个副本，端口分别为8762,8763，分别向服务注册中心注册
     * sercvice-ribbon端口为8764,向服务注册中心注册
     * 当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口；
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }


}