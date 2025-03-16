package com.example.testtaskkrainet.repository

import com.example.testtaskkrainet.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>