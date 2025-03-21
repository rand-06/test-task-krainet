package com.example.testtaskkrainet.service

import com.example.testtaskkrainet.model.dto.*
import com.example.testtaskkrainet.model.*
import com.example.testtaskkrainet.repository.ProjectRepository
import com.example.testtaskkrainet.repository.RecordRepository
import com.example.testtaskkrainet.repository.UserRepository
import org.springframework.stereotype.Service
import com.example.testtaskkrainet.tools.*
import org.springframework.data.repository.findByIdOrNull

@Service
class RecordService (
    val recordRepository: RecordRepository,
    val userRepository: UserRepository,
    val projectRepository: ProjectRepository
    ){

    fun createRecord(record: CreateRecordDto) : Record {
        return recordRepository.save(record.toRecord(userRepository, projectRepository))
    }

    fun getRecordById(id:Long):Record?{
        return recordRepository.findByIdOrNull(id)
    }

    fun getRecordsByProjectId(projectId: Long):List<Record>{
        val project = projectRepository.findByIdOrNull(projectId) ?: return listOf()
        return recordRepository.findRecordsByProjectId(project)
    }

    fun getRecordsByUserId(userId: Long):List<Record>{
        val user = userRepository.findByIdOrNull(userId) ?: return listOf()
        return recordRepository.findRecordsByUserId(user)
    }

    fun getAllRecords():List<Record>{
        return recordRepository.findAll()
    }

    fun editRecord(record: EditRecordDto):Record?{
        val record0 = recordRepository.findByIdOrNull(record.id)?:return null

        record0.name        = record.name
        record0.startTime   = record.startTime
        record0.finishTime  = record.finishTime
        record0.userId      = userRepository.findByIdOrNull(record.userId)
        record0.projectId   = projectRepository.findByIdOrNull(record.projectId)
        return recordRepository.save(record0)
    }

    fun deleteRecord(id: Long){
        recordRepository.deleteById(id)
    }
}