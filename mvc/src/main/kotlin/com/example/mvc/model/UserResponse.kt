package com.example.mvc.model

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserResponse
(
    var result: Result? = null,
    var description: String? = null,
    var user: MutableList<UserRequest>? = null
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Result
(
    var resultCode: String? = null,
    var resultMessage: String? = null
)
