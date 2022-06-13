package com.example.myapplication.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Question(
    @SerialName("answer")
    val answer: Answer,
    @SerialName("id")
    val id: Int,
    @SerialName("question")
    val question: String,
    @SerialName("type")
    val type: String
)