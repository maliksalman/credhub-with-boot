package com.smalik.credhubwithboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${hello.message:Hello World!}")
    private String helloMessage;

    @Value("${complex.config.foo:bar}")
    private String complexConfigFoo;

    @GetMapping("/hello")
    public String sayHello() {
        return helloMessage;
    }

    @GetMapping("/complex")
    public String getComplexConfig() {
        return complexConfigFoo;
    }
}
