package com.hucs.manager.core.home;

import com.hucs.manager.core.player.Player;
import com.hucs.manager.core.player.Position;
import com.hucs.manager.core.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class HomeService {

    @Autowired
    private CurrentUser currentUser;

    public HomeResource getHome() {
        return HomeResource.builder()
                .nextMatches(Arrays.asList(
                        LocalDate.now().plusWeeks(1),
                        LocalDate.now().plusWeeks(2)
                ))
                .bestPerformancePlayers(
                        Arrays.asList(
                                        Player.builder().name("João do Gol").position(Position.GKP).build(),
                                        Player.builder().name("Ricardo da Defesa").position(Position.DEF).build()
                ))
                .username(currentUser.getCurrentUser())
                .build();
    }

}
