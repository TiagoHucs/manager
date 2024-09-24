package com.hucs.manager.web.controllers.kanban;

import com.hucs.manager.core.task.TaskService;
import com.hucs.manager.web.controllers.task.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kanban")
public class KanbanController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public KanbanResorce getKanban() {
        return KanbanResorce.builder()
                .tasks(TaskMapper.map(taskService.findAll()))
                .build();
    }

}
