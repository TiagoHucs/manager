package com.hucs.manager.core.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void save(Task task){
        this.taskRepository.save(task);
    }

    public List<Task> findAll(){
        return this.taskRepository.findAll();
    }

    public List<Task> findByStatus(TaskStatus status){
        return this.taskRepository.findByStatus(status);
    }


    public Task open(Long id) {
        return this.taskRepository.getReferenceById(id);
    }

    public void delete(Long id) {
        this.taskRepository.deleteById(id);
    }

    /*personalizadas*/

    public void toEvolve(Long id){
        Task task = open(id);
        switch (task.getStatus()){
            case OPEN:
                task.setStatus(TaskStatus.IN_PROGRESS);
                task.setStartedDateTime(LocalDateTime.now());
                save(task);
                break;
            case IN_PROGRESS:
                task.setStatus(TaskStatus.CLOSED);
                task.setClosedDateTime(LocalDateTime.now());
                save(task);
                break;
            case CLOSED:
                delete(task.getId());
                break;
        }
    }
}
