package com.example.todolist.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ErrorResponse(
    var resultCode: String? = null,
    var httpStatus: String? = null,
    var httpMethod: String? = null,
    var message: String? = null,
    var path : String? = null,
    var timeStamp: LocalDateTime? = null,
    var error: MutableList<Error>? = null
)

data class Error(
    var field: String? = null,
    var message: String? = null,
    var value: Any? = null,
)