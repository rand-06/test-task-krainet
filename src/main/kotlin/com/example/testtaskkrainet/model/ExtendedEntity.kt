package com.example.testtaskkrainet.model

import jakarta.persistence.*

@MappedSuperclass
abstract class ExtendedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long = 0L
}
