package com.taskmanagement.service;

import com.taskmanagement.entity.Project;
import com.taskmanagement.entity.User;
import com.taskmanagement.repository.Projectrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private Projectrepository projectrepository;

    @Override
    public List<Project> getAllProject() {
        return projectrepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectrepository.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
    }
    @Override
    public Project createProject(Project project) {
        return projectrepository.save(project);
    }

    @Override
    public Project updateProject(Long id, Project project) {
        Project exists=getProjectById(id);
        exists.setProjectName(project.getProjectName());
        exists.setProjectDescription(project.getProjectDescription());
        return projectrepository.save(exists);
    }

    @Override
    public void deleteProject(Long id) {
        projectrepository.deleteById(id);
    }
}
