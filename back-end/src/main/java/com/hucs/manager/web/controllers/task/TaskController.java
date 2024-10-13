package com.hucs.manager.web.controllers.task;

import com.hucs.manager.core.config.NegocioException;
import com.hucs.manager.core.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hucs.manager.web.controllers.task.TaskMapper.map;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/to-save", method = RequestMethod.GET)
    public ResponseEntity<TaskEditerDTO> toSave() throws NegocioException {
        return ResponseEntity.ok().body(new TaskEditerDTO());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody TaskDTO taskDTO) throws NegocioException {
        taskService.save(map(taskDTO));
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @RequestMapping(value = "/open/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDTO> open(@PathVariable Long id) throws NegocioException {
        return ResponseEntity.ok().body(map(taskService.open(id)));
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public ResponseEntity<List<TaskDTO>> findAll() throws NegocioException {
        return ResponseEntity.ok().body(map(taskService.findAll()));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) throws NegocioException {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /*personal*/
    @RequestMapping(value = "/to-evolve/{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> toEvolve(@PathVariable Long id) throws NegocioException {
        taskService.toEvolve(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
