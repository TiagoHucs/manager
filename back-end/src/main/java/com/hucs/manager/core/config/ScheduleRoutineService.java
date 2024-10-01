package com.hucs.manager.core.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleRoutineService {

    // Método que será executado periodicamente
    @Scheduled(fixedRate = 60000) // Roda a cada 1 minuto
    public void execute() {
        System.out.println("Executando rotina");
    }
}
