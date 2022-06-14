package com.example.androidclient.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.util.*

data class ToDoDTO(
    @SerializedName("index")
    var index: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("description")
    var discription: String? = null,

    @SerializedName("schedule")
    var schedule: String? = null,

    @SerializedName("created_at")
    var createdAt: String? = null,

    @SerializedName("updated_at")
    var updatedAt: String? = null
)
{
    override fun toString(): String
    {
        return "{" + "\n" +
                "index = " + index + "\n" +
                "title = " + title + "\n" +
                "discription = " + discription + "\n" +
                "schedule = " + schedule + "\n" +
                "created_at = " + createdAt + "\n" +
                "updated_at = " + updatedAt + "\n" +
                "}"
    }


}