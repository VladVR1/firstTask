package com.example.myapplication.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Answer(
    @SerialName("answers")
    val answers: List<AnswerX>,
    @SerialName("correct_answers")
    val correctAnswers: List<String>
)