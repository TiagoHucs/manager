package com.hucs.manager.web.controllers.market;

import com.hucs.manager.core.market.MarketService;
import com.hucs.manager.core.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @GetMapping
    public ResponseEntity<List<Player>> get() {
        return ResponseEntity.ok().body(marketService.findAll());
    }

}