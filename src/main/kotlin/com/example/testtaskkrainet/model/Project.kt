package com.example.testtaskkrainet.model

import jakarta.persistence.*

@Table(name = "projects")
@Entity
class Project (

        @Column(name = "name")
        var name: String = "",

        @OneToMany(mappedBy = "projectId")
        var records: List<Record>? = null
) : ExtendedEntity()