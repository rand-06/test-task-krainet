package com.example.testtaskkrainet.model

import jakarta.persistence.*

@Table(name = "projects")
@Entity
class Project (

        @Column(name = "name")
        val name: String = "",

        @OneToMany(mappedBy = "projectId")
        val records: List<Record>? = null
) : ExtendedEntity()