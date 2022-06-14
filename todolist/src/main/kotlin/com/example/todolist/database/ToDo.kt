package com.example.todolist.database

import java.time.LocalDateTime

data class ToDo(
    var index: Int? = null,
    var title: String? = null,
    var description: String? = null,
    var schedule: LocalDateTime? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)
