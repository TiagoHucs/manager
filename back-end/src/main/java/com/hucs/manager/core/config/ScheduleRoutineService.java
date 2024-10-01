package com.hucs.manager.core.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleRoutineService {

    // Método que será executado periodicamente
    @Scheduled(fixedRate = 10000) // Roda a cada 10 segundos
    public void execute() {
        System.out.println("Rotina em segundo plano executada e mensagem salva no banco.");
    }
}
