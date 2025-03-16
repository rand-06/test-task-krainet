package com.example.testtaskkrainet.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "records")
@Entity
class Record (

        @Column(name = "name")
        var name: String = "",

        @Column(name = "start_time")
        var startTime: LocalDateTime = LocalDateTime.now(),

        @Column(name = "finish_time")
        var finishTime: LocalDateTime = LocalDateTime.now(),

        @ManyToOne
        @JoinColumn(name = "user_id")
        var userId: User? = null,

        @ManyToOne
        @JoinColumn(name = "project_id")
        var projectId: Project? = null

): ExtendedEntity()