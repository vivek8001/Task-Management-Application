package com.taskmanagement.controller;

import com.taskmanagement.entity.Project;
import com.taskmanagement.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Project")
public class ProjectController {

    private ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects(){
       return projectService.getAllProject();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id,@RequestBody Project project){
        return projectService.updateProject(id,project);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project){
        return  projectService.createProject(project);
    }

    @DeleteMapping
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }

}
