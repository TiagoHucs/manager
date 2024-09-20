package com.hucs.manager.core.home;

import com.hucs.manager.core.task.TaskService;
import com.hucs.manager.core.user.CurrentUser;
import com.hucs.manager.web.controllers.task.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private CurrentUser currentUser;

    @Autowired
    private TaskService taskService;

    public HomeResource getHome() {
        return HomeResource.builder()
                .tasks(TaskMapper.map(taskService.findAll()))
                .welcome("Welcome to initial archetype").build();
    }

}
