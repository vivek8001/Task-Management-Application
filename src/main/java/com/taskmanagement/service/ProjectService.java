package com.taskmanagement.service;

import com.taskmanagement.entity.Project;
import com.taskmanagement.entity.User;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProject();
    Project getProjectById(Long id);
    Project createProject(Project project);
    Project updateProject(Long id,Project project);
    void deleteProject(Long id);
}
