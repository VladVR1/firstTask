package com.example.myapplication.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionEntry(
    @SerialName("questions")
    val questions: List<Question>,
)