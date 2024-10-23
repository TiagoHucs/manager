package com.hucs.manager.core.task;

import com.hucs.manager.core.config.NegocioException;
import com.hucs.manager.core.patterns.Validator;
import com.hucs.manager.web.controllers.task.TaskDTO;

public class TaskValidator implements Validator<TaskDTO> {

    @Override
    public void validate(TaskDTO task) throws NegocioException{
        if (task.getStatusCode() == null){
            throw new NegocioException("Campo status é obrigatório");
        }
    }

}
