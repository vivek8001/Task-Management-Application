package com.taskmanagement.controller;

import com.taskmanagement.entity.Tasks;
import com.taskmanagement.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private  final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Tasks> getAllTask(){
        return taskService.getAllTasks();
    }

    @GetMapping("{/id}")
    public Tasks getTask(@PathVariable Long id){
        return taskService.getTaskbyId(id);
    }

    @PostMapping
    public Tasks createTask(@RequestBody Tasks tasks){
        return taskService.createTask(tasks);
    }

    @PutMapping("{/id}")
    public Tasks updateTask(@PathVariable Long id, @RequestBody Tasks tasks){
        return taskService.updateTask(id,tasks);
    }

    @DeleteMapping("{/id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
