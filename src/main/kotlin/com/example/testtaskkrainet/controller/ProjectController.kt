package com.example.testtaskkrainet.controller

import com.example.testtaskkrainet.model.Project
import com.example.testtaskkrainet.model.dto.CreateProjectDto
import com.example.testtaskkrainet.service.ProjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/projects")
class ProjectController (val projectService: ProjectService){
    @GetMapping
    fun getProjectById(@RequestParam id: Long):ResponseEntity<Project?>{
        return ResponseEntity.status(HttpStatus.OK).body(
            projectService.getProject(id)
        )
    }

    @PostMapping
    fun createNewProject(@RequestBody project: CreateProjectDto):ResponseEntity<Project>{
        return ResponseEntity.status(HttpStatus.OK).body(
            projectService.createProject(project)
        )
    }

    @PatchMapping
    fun editProject(@RequestBody project: Project):ResponseEntity<Project>{
        return ResponseEntity.status(HttpStatus.OK).body(
            projectService.editProject(project)
        )
    }

    @DeleteMapping
    fun deleteProject(@RequestParam id: Long): ResponseEntity<HttpStatus>{
        projectService.deleteProject(id)
        return ResponseEntity(HttpStatus.OK)
    }
}