package com.example.member.domain

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@Entity
data class Content(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var userName: String? = null,

    var title: String? = null,

    var text: String ?= null,

    var createdAt: LocalDateTime? = null
)