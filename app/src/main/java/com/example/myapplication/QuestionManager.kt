package com.example.myapplication
import android.content.Context
import com.example.myapplication.model.Question
import com.example.myapplication.model.QuestionEntry
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class QuestionManager(private val context: Context) {

    fun getQuestion(type:String, count:Int):List<Question> {


        val json = context.readTextFromAsset()
        val questionEntry: QuestionEntry = Json.decodeFromString(json)
        questionEntry.questions.forEach { _ ->
            json.length + 1
        }
       return TODO()
    }

    private fun Context.readTextFromAsset(): String{
        return assets.open("Question.json").bufferedReader().use {
            it.readText()}
    }
}