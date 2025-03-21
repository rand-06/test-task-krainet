package com.example.testtaskkrainet.tools

import com.example.testtaskkrainet.model.*
import com.example.testtaskkrainet.model.dto.*
import com.example.testtaskkrainet.repository.ProjectRepository
import com.example.testtaskkrainet.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull


fun CreateRecordDto.toRecord(
    userRepository: UserRepository,
    projectRepository: ProjectRepository):Record{
    return Record(
        name        = this.name,
        startTime   = this.startTime,
        finishTime  = this.finishTime,
        userId      = userRepository.findByIdOrNull(this.userId),
        projectId   = projectRepository.findByIdOrNull(this.projectId)
    )
}

fun CreateUserDto.toUser():User{
    return User(this.name, listOf())
}

fun CreateProjectDto.toProject(): Project{
    return Project(this.name, listOf())
}

fun User.toShortUserDto():ShortUserDto{
    return ShortUserDto(
        this.id,
        this.name
    )
}

fun Project.toShortProjectDto():ShortProjectDto{
    return ShortProjectDto(
        this.id,
        this.name
    )
}

fun Record.toShowRecordDto():ShowRecordDto{
    return ShowRecordDto(
        this.id,
        this.name,
        this.startTime,
        this.finishTime,
        this.userId?.toShortUserDto(),
        this.projectId?.toShortProjectDto()
    )
}

fun List<Record>.toListOfShowRecordDto():List<ShowRecordDto>{
    val ans :MutableList<ShowRecordDto> = mutableListOf()
    for (i in this) ans.add(i.toShowRecordDto())
    return ans.toList()
}

fun User.toShowUserDto():ShowUserDto{
    return ShowUserDto(
        this.id,
        this.name,
        this.records?.toListOfShowRecordDto()
    )
}

fun List<User>.toListOfShowUserDto():List<ShowUserDto>{
    val ans :MutableList<ShowUserDto> = mutableListOf()
    for (i in this) ans.add(i.toShowUserDto())
    return ans.toList()
}

fun Project.toShowProjectDto():ShowProjectDto{
    return ShowProjectDto(
        this.id,
        this.name,
        this.records?.toListOfShowRecordDto()
    )
}

fun List<Project>.toListOfShowProjectDto():List<ShowProjectDto>{
    val ans :MutableList<ShowProjectDto> = mutableListOf()
    for (i in this) ans.add(i.toShowProjectDto())
    return ans.toList()
}