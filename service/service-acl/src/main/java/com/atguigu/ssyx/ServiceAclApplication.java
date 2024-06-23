package com.atguigu.ssyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: ServiceAclApplication
 * Package: com.atguigu.ssyx
 * desc: 权限管理模块启动类
 * @author lzyy
 */

@SpringBootApplication
@ComponentScan("com.atguigu")
public class ServiceAclApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class, args);
    }
}
