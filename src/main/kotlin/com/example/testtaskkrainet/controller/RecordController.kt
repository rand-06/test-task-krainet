package com.example.testtaskkrainet.controller

import com.example.testtaskkrainet.service.RecordService
import com.example.testtaskkrainet.model.Record
import com.example.testtaskkrainet.model.dto.CreateRecordDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/records")
class RecordController (val recordService: RecordService){
    @GetMapping
    fun getRecordById(@RequestParam id: Long):ResponseEntity<Record?>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.getRecordById(id)
        )
    }

    @PostMapping
    fun createRecord(@RequestBody record: CreateRecordDto):ResponseEntity<Record>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.createRecord(record)
        )
    }

    @PatchMapping
    fun editRecord(@RequestBody record: Record):ResponseEntity<Record?>{
        return ResponseEntity.status(HttpStatus.OK).body(
            recordService.editRecord(record)
        )
    }

    @DeleteMapping
    fun deleteRecord(@RequestParam id: Long):ResponseEntity<HttpStatus>{
        recordService.deleteRecord(id)
        return ResponseEntity(HttpStatus.OK)
    }

}