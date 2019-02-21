package com.smalik.credhubwithboot;

import com.smalik.credhubwithboot.ApplicationConfiguration.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${message:Hello World!}")
    private String message;

    @Value("${inner.foo:bar}")
    private String innerFoo;

    @Autowired
    private ServiceConfig config;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

    @GetMapping("/inner")
    public String getInnerFoo() {
        return innerFoo;
    }

    @GetMapping("/config")
    public String getConfig() {
        return String.format("Url=%s, Username=%s, Password=%s", config.getUrl(), config.getUsername(), config.getPassword());
    }
}
