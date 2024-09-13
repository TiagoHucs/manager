package com.hucs.manager.web.controllers.version;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class VersionController {

    @GetMapping("/version")
    public String getHome() {
        return "0.0.1";
    }


}