package com.hucs.manager.core.player;

import com.hucs.manager.core.util.GeradorDePlayers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> generateRandomPlayers() {
        return Arrays.asList(
                Player.builder().name("João do Gol").position(Position.GKP).build(),
                Player.builder().name("Ricardo da Defesa").position(Position.DEF).build(),
                Player.builder().name("Will da Defesa").position(Position.DEF).build(),
                Player.builder().name("Paul da Defesa").position(Position.DEF).build(),
                Player.builder().name("Juca da Defesa").position(Position.DEF).build(),
                Player.builder().name("Jauler da Meio").position(Position.MID).build(),
                Player.builder().name("Carlos da Meio").position(Position.MID).build(),
                Player.builder().name("Alberto da Meio").position(Position.MID).build(),
                Player.builder().name("Nilberto da Meio").position(Position.MID).build(),
                Player.builder().name("Gilson da Frente").position(Position.ATT).build(),
                Player.builder().name("Chaves da Frente").position(Position.ATT).build()
        );
    }

    //TODO: remover hard coded
    public List<Player> findAll() {
        boolean empty = playerRepository.count() < 1;
        if(empty){
            playerRepository.saveAll(GeradorDePlayers.gerarPlayers());
        }
        return playerRepository.findAll();
    }
}
