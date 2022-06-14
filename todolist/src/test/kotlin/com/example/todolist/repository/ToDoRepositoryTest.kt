package com.example.todolist.repository

import com.example.todolist.config.AppConfig
import com.example.todolist.database.ToDo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [ToDoRepositoryImpl::class, AppConfig::class])
class ToDoRepositoryTest
{
    @Autowired
    lateinit var todoRepositoryImpl: ToDoRepositoryImpl

    @BeforeEach
    fun before()
    {
        todoRepositoryImpl.todoDataBase.init()
    }

    @Test
    fun saveTest()
    {
        val todo = ToDo().apply()
        {
            this.title = "테스트 일정"
            this.description = "테스트"
            this.schedule = LocalDateTime.now()
        }

        with(todoRepositoryImpl.save(todo))
        {
            Assertions.assertEquals(1, this?.index)
            Assertions.assertNotNull(this?.createdAt)
            Assertions.assertNotNull(this?.updatedAt)
            Assertions.assertEquals("테스트 일정", this?.title)
            Assertions.assertEquals("테스트", this?.description)
        }
    }

    @Test
    fun saveAllTest()
    {
        val todoList = mutableListOf(
            ToDo().apply()
            {
                this.title = "테스트 일정1"
                this.description = "테스트"
                this.schedule = LocalDateTime.now()
            },
            ToDo().apply()
            {
                this.title = "테스트 일정2"
                this.description = "테스트2"
                this.schedule = LocalDateTime.now()
            },
            ToDo().apply()
            {
                this.title = "테스트 일정3"
                this.description = "테스트3"
                this.schedule = LocalDateTime.now()
            }
        )

        val result = todoRepositoryImpl.saveAll(todoList)

        Assertions.assertEquals(true, result)
    }

    @Test
    fun findOneTest()
    {
        val todoList = mutableListOf(
            ToDo().apply()
            {
                this.title = "테스트 일정1"
                this.description = "테스트"
                this.schedule = LocalDateTime.now()
            },
            ToDo().apply()
            {
                this.title = "테스트 일정2"
                this.description = "테스트2"
                this.schedule = LocalDateTime.now()
            },
            ToDo().apply()
            {
                this.title = "테스트 일정3"
                this.description = "테스트3"
                this.schedule = LocalDateTime.now()
            }
        )

        todoRepositoryImpl.saveAll(todoList)

        with(todoRepositoryImpl.findOne(2))
        {
            Assertions.assertNotNull(this)
            Assertions.assertEquals("테스트 일정2", this?.title)
        }
    }

    @Test
    fun updateTest()
    {
        val todo = ToDo().apply()
        {
            this.title = "테스트 일정"
            this.description = "테스트"
            this.schedule = LocalDateTime.now()
        }

        val insertTodo = todoRepositoryImpl.save(todo)

        val newTodo = ToDo().apply()
        {
            this.index = insertTodo?.index
            this.title = "업데이트 테스트 일정"
            this.description = "업데이트 테스트"
            this.schedule = LocalDateTime.now()
        }

        with(todoRepositoryImpl.save(newTodo))
        {
            Assertions.assertNotNull(this)
            Assertions.assertEquals(this?.index, insertTodo?.index)
            Assertions.assertEquals("업데이트 테스트 일정", this?.title)
            Assertions.assertEquals("업데이트 테스트", this?.description)
        }
    }
}
