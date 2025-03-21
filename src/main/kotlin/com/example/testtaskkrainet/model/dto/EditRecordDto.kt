package com.example.testtaskkrainet.model.dto

import java.time.LocalDateTime

class EditRecordDto (
    var id: Long,
    var name: String,
    var startTime: LocalDateTime,
    var finishTime: LocalDateTime,
    var userId: Long?,
    var projectId: Long?
)