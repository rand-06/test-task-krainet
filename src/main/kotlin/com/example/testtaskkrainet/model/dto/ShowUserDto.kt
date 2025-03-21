package com.example.testtaskkrainet.model.dto

class ShowUserDto (
    var id: Long,
    var name: String = "",
    var records: List<ShowRecordDto>?
)