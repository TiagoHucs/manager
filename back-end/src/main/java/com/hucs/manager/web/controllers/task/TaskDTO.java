package com.hucs.manager.web.controllers.task;

import com.hucs.manager.core.task.TaskStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TaskDTO {

    private Long id;
    private String name;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdDateTime;
    private LocalDateTime closedDateTime;

}
