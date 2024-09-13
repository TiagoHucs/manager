package com.hucs.manager.core.market;

import com.hucs.manager.core.player.Player;
import com.hucs.manager.core.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    @Autowired
    private PlayerService playerService;

    public List<Player> findAll(){
        return playerService.findAll();
    }

}
