package com.example.myapplication.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnswerX(
    @SerialName("answer")
    val answer: String,
    @SerialName("id")
    val id: Int
)