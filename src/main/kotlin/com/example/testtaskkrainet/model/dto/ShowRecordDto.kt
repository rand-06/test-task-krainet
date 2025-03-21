package com.example.testtaskkrainet.model.dto

import java.time.LocalDateTime

class ShowRecordDto (
        var id: Long,
        var name: String,
        var startTime: LocalDateTime,
        var finishTime: LocalDateTime,
        var userId: ShortUserDto?,
        var projectId: ShortProjectDto?
)