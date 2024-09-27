package com.hucs.manager.core.user;

import com.hucs.manager.core.task.Task;
import com.hucs.manager.core.task.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
