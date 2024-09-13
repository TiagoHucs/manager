package com.hucs.manager.web.controllers.home;

import com.hucs.manager.core.home.HomeResource;
import com.hucs.manager.core.home.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseEntity<HomeResource> getHome() {
        return ResponseEntity.ok().body(homeService.getHome());
    }

}
