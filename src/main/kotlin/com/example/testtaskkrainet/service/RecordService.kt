package com.example.testtaskkrainet.service

import com.example.testtaskkrainet.model.dto.*
import com.example.testtaskkrainet.model.*
import com.example.testtaskkrainet.repository.RecordRepository
import org.springframework.stereotype.Service
import com.example.testtaskkrainet.tools.*
import org.springframework.data.repository.findByIdOrNull

@Service
class RecordService (val recordRepository: RecordRepository){

    fun createRecord(record: CreateRecordDto) : Record {
        return recordRepository.save(record.toRecord())
    }

    fun getRecordById(id:Long):Record?{
        return recordRepository.findByIdOrNull(id)
    }

    fun editRecord(record: Record):Record?{
        val record0 = recordRepository.findByIdOrNull(record.id)?:return null

        record0.name        = record.name
        record0.startTime   = record.startTime
        record0.finishTime  = record.finishTime
        record0.userId      = record.userId
        record0.projectId   = record.projectId
        return recordRepository.save(record0)
    }

    fun deleteRecord(id: Long){
        recordRepository.deleteById(id)
    }
}