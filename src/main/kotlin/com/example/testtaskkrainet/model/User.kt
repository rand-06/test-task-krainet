package com.example.testtaskkrainet.model

import jakarta.persistence.*


@Table(name = "users")
@Entity
class User (

        @Column(name = "name")
        val name: String = "",

        @OneToMany(mappedBy = "userId")
        val records: List<Record>? = null
) : ExtendedEntity()