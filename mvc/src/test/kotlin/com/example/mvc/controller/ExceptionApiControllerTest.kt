package com.example.mvc.controller

import com.example.mvc.model.UserRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest
@AutoConfigureMockMvc
class ExceptionApiControllerTest
{
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun helloTest()
    {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/hello-exception")
        ).andExpect(
            MockMvcResultMatchers.status().isBadRequest
        ).andExpect(
            MockMvcResultMatchers.content().string("hello")
        ).andDo(
            MockMvcResultHandlers.print()
        )
    }

    @Test
    fun getTest()
    {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "cheel")
        queryParams.add("age", "9")

        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/exception-get").queryParams(queryParams)
        ).andExpect(
            MockMvcResultMatchers.status().isBadRequest
        ).andExpect(
            MockMvcResultMatchers.content().contentType("application/json")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.result_code").value("Error")
        ).andDo(
            MockMvcResultHandlers.print()
        )
    }

    @Test
    fun postTest()
    {
        val ur = UserRequest().apply()
        {
            this.name = "cheel"
            this.age = 25
            this.phoneNumber = "010-1111-2222"
            this.address = "으아아"
            this.email = "dsad@dasda.com"
            this.createdAt = "2111-11-11 11:11:11"
        }

        val json = jacksonObjectMapper().writeValueAsBytes(ur)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/exception-post").content(json).contentType("application/json").accept("application/json")
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andExpect(
            MockMvcResultMatchers.jsonPath("\$.name").value("cheel")
        ).andDo(
            MockMvcResultHandlers.print()
        )
    }
}