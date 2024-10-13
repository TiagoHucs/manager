package com.hucs.manager.web.controllers.task;

import com.hucs.manager.core.task.TaskStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TaskEditerDTO {


    public TaskEditerDTO() {
        this.statusList = map(List.of(TaskStatus.values()));
    }

    private List<EnumDTO> statusList;

    private List<EnumDTO> map(List<TaskStatus> statusList) {
        List<EnumDTO> dtoList = new ArrayList<>();

        for (TaskStatus status : statusList) {
            dtoList.add(EnumDTO.builder()
                    .code(status.name())
                    .description(status.description)
                    .build());
        }

        return dtoList;
    }

}
