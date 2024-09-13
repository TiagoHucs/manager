package com.hucs.manager.core.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PlayerRepository extends JpaRepository<Player, Long> {
}
