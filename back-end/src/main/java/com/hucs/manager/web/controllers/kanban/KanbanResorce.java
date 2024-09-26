package com.hucs.manager.web.controllers.kanban;

import com.hucs.manager.web.controllers.task.TaskDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class KanbanResorce {

    List<TaskDTO> openTasks;
    List<TaskDTO> progressTasks;
    List<TaskDTO> closedTasks;
}
