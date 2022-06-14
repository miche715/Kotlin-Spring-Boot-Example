package com.example.todolist.service

import com.example.todolist.database.ToDo
import com.example.todolist.database.convertToDo
import com.example.todolist.model.ToDoDto
import com.example.todolist.model.convertToDoDto
import com.example.todolist.repository.ToDoRepositoryImpl
import org.springframework.stereotype.Service

@Service
class ToDoService(val todoRepositoryImpl: ToDoRepositoryImpl)
{
    fun create(todoDto: ToDoDto): ToDoDto?
    {
        return todoDto.let()
        {
            ToDo().convertToDo(it)
        }.let()
        {
            todoRepositoryImpl.save(it)
        }?.let()
        {
          ToDoDto().convertToDoDto(it)
        }
    }

    fun read(index: Int): ToDoDto?
    {
        return todoRepositoryImpl.findOne(index)?.let()
        {
            ToDoDto().convertToDoDto(it)
        }
    }

    fun readAll(): MutableList<ToDoDto>
    {
        return todoRepositoryImpl.findAll().map()
        {
            ToDoDto().convertToDoDto(it)
        }.toMutableList()
    }

    fun update(todoDto: ToDoDto): ToDoDto?
    {
        return todoDto.let()
        {
            ToDo().convertToDo(it)
        }.let()
        {
            todoRepositoryImpl.save(it)
        }?.let()
        {
            ToDoDto().convertToDoDto(it)
        }
    }

    fun delete(index: Int): Boolean
    {
        return todoRepositoryImpl.delete(index)
    }
}