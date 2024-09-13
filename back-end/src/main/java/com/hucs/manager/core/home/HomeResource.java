package com.hucs.manager.core.home;

import com.hucs.manager.core.player.Player;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class HomeResource {

    String username;
    List<LocalDate> nextMatches;
    List<Player> bestPerformancePlayers;

}
