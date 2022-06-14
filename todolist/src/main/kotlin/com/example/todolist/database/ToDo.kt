package com.example.todolist.database

import com.example.todolist.model.ToDoDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class ToDo(
    var index: Int? = null,
    var title: String? = null,
    var description: String? = null,
    var schedule: LocalDateTime? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)

fun ToDo.convertToDo(toDoDto: ToDoDto): ToDo
{
    return ToDo().apply()
    {
        this.index = toDoDto.index
        this.title = toDoDto.title
        this.description = toDoDto.description
        this.schedule = LocalDateTime.parse(toDoDto.schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.createdAt = toDoDto.createdAt
        this.updatedAt = toDoDto.updatedAt
    }
}
