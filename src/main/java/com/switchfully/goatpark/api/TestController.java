package com.switchfully.goatpark.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    @PreAuthorize("hasAuthority('GET_CUSTOMER_HELLO_WORLD')")
    public String methodName() {
        return "successfull";
    }

}
