package com.taskmanagement.service;

import com.taskmanagement.entity.Tasks;
import com.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Tasks getTaskbyId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));
    }

    @Override
    public Tasks createTask(Tasks tasks) {
        return taskRepository.save(tasks);
    }

    @Override
    public Tasks updateTask(Long id, Tasks tasks) {
       Tasks exists=getTaskbyId(id);
       exists.setTitle(tasks.getTitle());
       exists.setStatus(tasks.isStatus());
       exists.setDetails(tasks.getDetails());
       return taskRepository.save(exists);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
