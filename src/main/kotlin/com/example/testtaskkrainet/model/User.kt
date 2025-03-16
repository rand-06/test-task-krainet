package com.example.testtaskkrainet.model

import jakarta.persistence.*


@Table(name = "users")
@Entity
class User (

        @Column(name = "name")
        var name: String = "",

        @OneToMany(mappedBy = "userId")
        var records: List<Record>? = null
) : ExtendedEntity()