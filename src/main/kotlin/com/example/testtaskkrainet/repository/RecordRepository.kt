package com.example.testtaskkrainet.repository

import com.example.testtaskkrainet.model.Project
import com.example.testtaskkrainet.model.Record
import com.example.testtaskkrainet.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordRepository : JpaRepository<Record, Long>{

    fun findRecordsByProjectId(projectId: Project): List<Record>
    fun findRecordsByUserId(userId: User): List<Record>
}