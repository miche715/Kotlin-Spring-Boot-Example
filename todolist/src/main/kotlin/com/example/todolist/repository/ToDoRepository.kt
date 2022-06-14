package com.example.todolist.repository

import com.example.todolist.database.ToDo

interface ToDoRepository
{
    fun save(todo: ToDo): ToDo?
    fun saveAll(todoList: MutableList<ToDo>): Boolean
    fun delete(index: Int): Boolean
    fun findOne(index: Int): ToDo?
    fun findAll(): MutableList<ToDo>
}
