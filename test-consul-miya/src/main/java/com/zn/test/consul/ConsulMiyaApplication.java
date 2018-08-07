package com.zn.test.consul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * consul 组件，它是一个提供服务发现和配置的工具。consul具有分布式、高可用、高扩展性。
 * consul 具有以下性质：
 *   (1) 服务发现：consul通过http 方式注册服务，并且服务与服务之间相互感应。
 *   (2) 服务健康监测
 *   (3) key/value 存储
 *   (4) 多数据中心
 * consul可运行在mac windows linux 等机器上。
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulMiyaApplication {

    @RequestMapping("/hi")
    public String home() {
        return "hi ,i'm miya";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsulMiyaApplication.class).web(true).run(args);
    }
}