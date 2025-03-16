package com.example.testtaskkrainet.tools

import com.example.testtaskkrainet.model.*
import com.example.testtaskkrainet.model.dto.*


fun CreateRecordDto.toRecord():Record{
    return Record(
        name        = this.name,
        startTime   = this.startTime,
        finishTime  = this.finishTime,
        userId      = this.userId,
        projectId   = this.projectId
    )
}

fun CreateUserDto.toUser():User{
    return User(this.name, listOf())
}

fun CreateProjectDto.toProject(): Project{
    return Project(this.name, listOf())
}