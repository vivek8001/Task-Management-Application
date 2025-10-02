package com.taskmanagement.repository;

import com.taskmanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Projectrepository extends JpaRepository<Project,Long> {
}
