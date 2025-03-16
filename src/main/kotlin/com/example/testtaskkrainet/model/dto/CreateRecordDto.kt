package com.example.testtaskkrainet.model.dto

import com.example.testtaskkrainet.model.Project
import com.example.testtaskkrainet.model.User
import java.time.LocalDateTime

class CreateRecordDto (
    val name: String,
    val startTime: LocalDateTime,
    val finishTime: LocalDateTime,
    val userId: User,
    val projectId: Project
)