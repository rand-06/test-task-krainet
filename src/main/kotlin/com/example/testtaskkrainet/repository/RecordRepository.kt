package com.example.testtaskkrainet.repository

import com.example.testtaskkrainet.model.Record
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordRepository : JpaRepository<Record, Long>