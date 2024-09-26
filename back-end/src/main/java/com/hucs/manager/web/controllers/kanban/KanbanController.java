package com.hucs.manager.web.controllers.kanban;

import com.hucs.manager.core.task.TaskService;
import com.hucs.manager.core.task.TaskStatus;
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
                .openTasks(TaskMapper.map(taskService.findByStatus(TaskStatus.OPEN)))
                .progressTasks(TaskMapper.map(taskService.findByStatus(TaskStatus.IN_PROGRESS)))
                .closedTasks(TaskMapper.map(taskService.findByStatus(TaskStatus.CLOSED)))
                .build();
    }

}
