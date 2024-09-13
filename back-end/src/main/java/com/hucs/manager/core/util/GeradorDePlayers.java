package com.hucs.manager.core.util;

import com.hucs.manager.core.player.Player;
import com.hucs.manager.core.player.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDePlayers {

    static String[] nomes = {
            "Lucas", "Mateus", "Gabriel", "Rafael", "Pedro",
            "João", "Thiago", "Felipe", "André", "Ricardo",
            "Carlos", "Marcelo", "Fernando", "Diego", "Victor",
            "Daniel", "Eduardo", "Henrique", "Rodrigo", "Alex"
    };

    static String[] sobrenomes = {
            "Silva", "Souza", "Oliveira", "Pereira", "Costa",
            "Almeida", "Ferreira", "Gomes", "Martins", "Santos",
            "Rodrigues", "Lima", "Araujo", "Ramos", "Barbosa",
            "Cavalcanti", "Freitas", "Moura", "Cardoso", "Borges"
    };

    public static List<Player> gerarPlayers() {
        Random random = new Random();
        Position[] positions = Position.values();
        List<Player> players = new ArrayList<>();

        for (String nome : nomes) {
            for (String sobrenome : sobrenomes) {
                players.add(Player.builder()
                        .name(nome + " " + sobrenome)
                        .strength(random.nextInt(50) + 1)
                        .position(positions[random.nextInt(positions.length)])
                        .build());
            }
        }

        return players;
    }
}
