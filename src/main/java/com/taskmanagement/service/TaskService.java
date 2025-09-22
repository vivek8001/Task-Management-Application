package com.taskmanagement.service;

import com.taskmanagement.entity.Tasks;


import java.util.List;


public interface TaskService {
    List<Tasks> getAllTasks();
    Tasks getTaskbyId(Long id);
    Tasks createTask(Tasks tasks);
    Tasks updateTask(Long id, Tasks tasks);
    void deleteTask(Long id);

}
