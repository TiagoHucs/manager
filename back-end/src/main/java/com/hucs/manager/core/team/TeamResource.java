package com.hucs.manager.core.team;

import com.hucs.manager.core.player.Player;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TeamResource {

    String teamname;
    List<Player> players;

}
