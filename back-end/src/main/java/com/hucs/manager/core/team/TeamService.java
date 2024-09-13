package com.hucs.manager.core.team;

import com.hucs.manager.core.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private PlayerService playerService;

    public TeamResource getUserTeam() {
        return TeamResource.builder()
                .teamname("My Dream Team")
                .players(playerService.findAll())
                .build();
    }
}
