package com.hucs.manager.web.controllers.task;

import com.hucs.manager.core.task.Task;
import com.hucs.manager.core.task.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {

    public static Task map(TaskDTO dto){
        return Task.builder()
                .id(dto.getId())
                .name(dto.getName())
                .status(TaskStatus.valueOf(dto.getStatusCode()))
                .description(dto.getDescription())
                .createdDateTime(dto.getCreatedDateTime())
                .startedDateTime(dto.getStartedDateTime())
                .closedDateTime(dto.getClosedDateTime())
                .build();
    }

    public static TaskDTO map(Task obj){

        return TaskDTO.builder()
                .id(obj.getId())
                .name(obj.getName())
                .statusCode(obj.getStatus() != null ?  obj.getStatus().name() : null)
                .description(obj.getDescription())
                .createdDateTime(obj.getCreatedDateTime())
                .startedDateTime(obj.getStartedDateTime())
                .closedDateTime(obj.getClosedDateTime())
                .build();
    }

    public static List<TaskDTO> map(List<Task> objs){
        List<TaskDTO> tasksDTO = new ArrayList<>();
        objs.forEach(task -> {
            tasksDTO.add(map(task));
        });
        return tasksDTO;
    }
}
