package com.hucs.manager.core.home;

import com.hucs.manager.web.controllers.task.TaskDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class HomeResource {

    String welcome;
    List<TaskDTO> tasks;

}
