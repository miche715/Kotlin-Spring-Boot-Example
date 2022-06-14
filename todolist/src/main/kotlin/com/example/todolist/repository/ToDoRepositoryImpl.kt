package com.example.todolist.repository

import com.example.todolist.database.ToDo
import com.example.todolist.database.ToDoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ToDoRepositoryImpl: ToDoRepository
{
    @Autowired
    lateinit var todoDataBase: ToDoDataBase

    override fun save(todo: ToDo): ToDo?
    {
        return todo.index?.let()
        {
            findOne(it)?.apply()
            {
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.updatedAt = LocalDateTime.now()
            }
        }?: kotlin.run()
        {
            todo.apply()
            {
                this.index = ++todoDataBase.index
                this.createdAt = LocalDateTime.now()
                this.updatedAt = LocalDateTime.now()
            }.run()
            {
                todoDataBase.todoList.add(todo)
                this
            }
        }

//        with(todo)
//        {
//            when(findOne(this.index))
//            {
//                null -> {
//                    return todo.apply()
//                    {
//                        this.index = ++todoDataBase.index
//                        this.createdAt = LocalDateTime.now()
//                        this.updatedAt = LocalDateTime.now()
//                    }.run()
//                    {
//                        todoDataBase.todoList.add(todo)
//                        this
//                    }
//                }
//                else -> {
//                    return todo.apply()
//                    {
//                        this.title = todo.title
//                        this.description = todo.description
//                        this.schedule = LocalDateTime.now()
//                        this.updatedAt = LocalDateTime.now()
//                    }
//                }
//            }
//        }
    }

    override fun saveAll(todoList: MutableList<ToDo>): Boolean
    {
        return try
        {
            for(tdl in todoList)
            {
                save(tdl)
            }
            true
        }
        catch(e: Exception)
        {
            false
        }
    }

    override fun delete(index: Int): Boolean
    {
        with(findOne(index))
        {
            when(this)
            {
                null -> {
                    return false
                }
                else -> {
                    todoDataBase.todoList.remove(this)
                    return true
                }
            }
        }

//        if(todo == null)
//        {
//            return false
//        }
//        else
//        {
//            todoDataBase.todoList.remove(todo)
//            return true
//        }

//        return todo?.let()
//        {
//            todoDataBase.todoList.remove(it)
//            true
//        }?: kotlin.run()
//        {
//            false
//        }
    }

    override fun findOne(index: Int): ToDo?
    {
        return todoDataBase.todoList.first()
        {
            it.index == index
        }
    }

    override fun findAll(): MutableList<ToDo>
    {
        return todoDataBase.todoList
    }
}
