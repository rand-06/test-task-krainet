package com.example.testtaskkrainet.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "records")
@Entity
class Record (

        @Column(name = "name")
        val name: String = "",

        @Column(name = "start_time")
        val startTime: LocalDateTime = LocalDateTime.now(),

        @Column(name = "finish_time")
        val finishTime: LocalDateTime = LocalDateTime.now(),

        @ManyToOne
        @JoinColumn(name = "user_id")
        val userId: User? = null,

        @ManyToOne
        @JoinColumn(name = "project_id")
        val projectId: Project? = null

): ExtendedEntity()