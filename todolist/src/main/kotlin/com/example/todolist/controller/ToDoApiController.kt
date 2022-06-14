package com.example.todolist.controller

import com.example.todolist.model.ToDoDto
import com.example.todolist.service.ToDoService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todo")
class ToDoApiController(val todoService: ToDoService)
{
    @GetMapping("")  // R
    fun read(@RequestParam(required = false) index: Int?): ResponseEntity<Any?>
    {
        return index?.let()
        {
            todoService.read(index)
        }?.let()
        {
            return ResponseEntity.ok(it)
        }?: kotlin.run()
        {
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "/api/todo/all").build()
        }
    }

    @GetMapping("/all")  // R
    fun readAll(): MutableList<ToDoDto>
    {
        return todoService.readAll()
    }

    @PostMapping("")  // C
    fun create(@RequestBody todoDto: ToDoDto): ToDoDto?
    {
        return todoService.create(todoDto)
    }

    @PutMapping("")  // U
    fun update(@RequestBody todoDto: ToDoDto): ResponseEntity<Any>
    {
        return todoDto.index?.let()
        {
            todoService.update(todoDto)
            return ResponseEntity.status(200).build()
        }?: kotlin.run()
        {
            todoService.create(todoDto)
            return ResponseEntity.status(201).build()
        }
    }

//    @PutMapping("")  // U
//    fun update(@RequestBody todoDto: ToDoDto): ToDoDto?
//    {
//        return todoService.create(todoDto)
//    }

    @DeleteMapping("")  // D
    fun delete(@RequestParam index: Int): ResponseEntity<Any>
    {
        if(!todoService.delete(index))
        {
            return ResponseEntity.status(500).build()
        }
        return ResponseEntity.ok().build()
    }
}