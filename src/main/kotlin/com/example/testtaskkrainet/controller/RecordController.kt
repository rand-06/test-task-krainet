package com.example.testtaskkrainet.controller

import com.example.testtaskkrainet.service.RecordService
import com.example.testtaskkrainet.model.dto.CreateRecordDto
import com.example.testtaskkrainet.model.dto.EditRecordDto
import com.example.testtaskkrainet.model.dto.ShowRecordDto
import com.example.testtaskkrainet.tools.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/records")
class RecordController (val recordService: RecordService){
    @GetMapping
    fun getRecordById(@RequestParam id: Long):ResponseEntity<ShowRecordDto?>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.getRecordById(id)?.toShowRecordDto()
        )
    }

    @GetMapping("/project")
    fun getRecordsByProjectId(@RequestParam project: Long):ResponseEntity<List<ShowRecordDto>>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.getRecordsByProjectId(project).toListOfShowRecordDto()
        )
    }

    @GetMapping("/user")
    fun getRecordsByUserId(@RequestParam user: Long):ResponseEntity<List<ShowRecordDto>>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.getRecordsByUserId(user).toListOfShowRecordDto()
        )
    }

    @GetMapping("/all")
    fun getAllRecords():ResponseEntity<List<ShowRecordDto>>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.getAllRecords().toListOfShowRecordDto()
        )
    }

    @PostMapping
    fun createRecord(@RequestBody record: CreateRecordDto):ResponseEntity<ShowRecordDto>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.createRecord(record).toShowRecordDto()
        )
    }

    @PatchMapping
    fun editRecord(@RequestBody record: EditRecordDto):ResponseEntity<ShowRecordDto?>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.editRecord(record)?.toShowRecordDto()
        )
    }

    @DeleteMapping
    fun deleteRecord(@RequestParam id: Long):ResponseEntity<HttpStatus>{
        recordService.deleteRecord(id)
        return ResponseEntity(HttpStatus.OK)
    }

}