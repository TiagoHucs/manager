package com.hucs.manager.web.controllers.team;

import com.hucs.manager.core.team.TeamResource;
import com.hucs.manager.core.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<TeamResource> getHome() {
        return ResponseEntity.ok().body(teamService.getUserTeam());
    }

}
