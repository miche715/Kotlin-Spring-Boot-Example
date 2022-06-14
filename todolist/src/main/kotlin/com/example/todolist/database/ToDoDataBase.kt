package com.example.todolist.database

data class ToDoDataBase(var index: Int = 0, var todoList: MutableList<ToDo> = mutableListOf())
{
    fun init()
    {
        this.index = 0
        this.todoList = mutableListOf()

        println("[* * * * * LOG * * * * *] ToDoDataBase init")
    }
}
