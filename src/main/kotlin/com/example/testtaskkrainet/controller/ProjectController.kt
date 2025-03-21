package com.example.testtaskkrainet.controller

import com.example.testtaskkrainet.model.Project
import com.example.testtaskkrainet.model.dto.CreateProjectDto
import com.example.testtaskkrainet.model.dto.ShowProjectDto
import com.example.testtaskkrainet.service.ProjectService
import com.example.testtaskkrainet.tools.toListOfShowProjectDto
import com.example.testtaskkrainet.tools.toShowProjectDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/projects")
class ProjectController (val projectService: ProjectService){
    @GetMapping
    fun getProjectById(@RequestParam id: Long):ResponseEntity<ShowProjectDto?>{
        return ResponseEntity.status(HttpStatus.OK).body(
            projectService.getProject(id)?.toShowProjectDto()
        )
    }

    @GetMapping("/all")
    fun getAllProjects(): ResponseEntity<List<ShowProjectDto>>{
        return ResponseEntity.status(HttpStatus.OK).body(
            projectService.getAll().toListOfShowProjectDto()
        )
    }

    @PostMapping
    fun createNewProject(@RequestBody project: CreateProjectDto):ResponseEntity<ShowProjectDto>{
        return ResponseEntity.status(HttpStatus.OK).body(
            projectService.createProject(project).toShowProjectDto()
        )
    }

    @PatchMapping
    fun editProject(@RequestBody project: Project):ResponseEntity<ShowProjectDto?>{
        return ResponseEntity.status(HttpStatus.OK).body(
            projectService.editProject(project)?.toShowProjectDto()
        )
    }

    @DeleteMapping
    fun deleteProject(@RequestParam id: Long): ResponseEntity<HttpStatus>{
        projectService.deleteProject(id)
        return ResponseEntity(HttpStatus.OK)
    }
}