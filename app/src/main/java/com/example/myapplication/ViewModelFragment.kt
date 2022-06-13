package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelFragment: ViewModel() {

    val userInput = MutableLiveData<String>()
    val radioBtnAnswer = MutableLiveData<String>()
    val checkBoxAnswer = MutableLiveData<String>()

    fun setDataUserInput(text: String){
        userInput.value = text
    }
    fun setDataRadioBtn(text: String){
        radioBtnAnswer.value =text
    }
    fun setDataCheckBox(text:String){
        checkBoxAnswer.value = text
    }
}