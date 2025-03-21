package com.example.testtaskkrainet.service

import com.example.testtaskkrainet.model.Project
import com.example.testtaskkrainet.model.dto.CreateProjectDto
import com.example.testtaskkrainet.repository.ProjectRepository
import org.springframework.data.repository.findByIdOrNull
import com.example.testtaskkrainet.tools.*
import org.springframework.stereotype.Service

@Service
class ProjectService (val projectRepository: ProjectRepository){
    fun createProject(project: CreateProjectDto) : Project{
        return projectRepository.save(project.toProject())
    }

    fun getAll(): List<Project>{
        return projectRepository.findAll()
    }

    fun getProject(id: Long): Project? {
        return projectRepository.findByIdOrNull(id)
    }

    fun editProject(project: Project) : Project?{
        val project0 = projectRepository.findByIdOrNull(project.id)?: return null
        project0.name = project.name
        return projectRepository.save(project0)
    }

    fun deleteProject(id: Long){
        projectRepository.deleteById(id)
    }
}