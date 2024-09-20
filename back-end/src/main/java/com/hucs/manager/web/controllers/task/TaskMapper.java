package com.hucs.manager.web.controllers.task;

import com.hucs.manager.core.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {

    static Task map(TaskDTO dto){
        return Task.builder()
                .id(dto.getId())
                .name(dto.getName())
                .status(dto.getStatus())
                .createdDateTime(dto.getCreatedDateTime())
                .closedDateTime(dto.getClosedDateTime())
                .build();
    }

    static TaskDTO map(Task obj){
        return TaskDTO.builder()
                .id(obj.getId())
                .name(obj.getName())
                .status(obj.getStatus())
                .createdDateTime(obj.getCreatedDateTime())
                .closedDateTime(obj.getClosedDateTime())
                .build();
    }

    static List<TaskDTO> map(List<Task> objs){
        List<TaskDTO> tasksDTO = new ArrayList<>();
        objs.forEach(task -> {
            tasksDTO.add(map(task));
        });
        return tasksDTO;
    }
}
