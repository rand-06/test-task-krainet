package com.example.testtaskkrainet.model.dto

import java.time.LocalDateTime

class CreateRecordDto (
    val name: String,
    val startTime: LocalDateTime,
    val finishTime: LocalDateTime,
    val userId: Long,
    val projectId: Long
)