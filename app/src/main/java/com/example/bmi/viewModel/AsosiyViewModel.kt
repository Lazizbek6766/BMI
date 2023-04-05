package com.example.bmi.viewModel

import androidx.lifecycle.ViewModel
import com.example.bmi.model.AsosiyModel
import com.example.bmi.model.QoshimchaModel
import com.example.bmi.model.QuestionModel
import com.example.bmi.model.repositori.Repositori

class AsosiyViewModel(
    val repositori: Repositori = Repositori()
):ViewModel() {
    fun newgeneratePassword(length: Int, complexity: Int){
        repositori.generatePassword(length, complexity)
    }
    val arrayListAsosiy:ArrayList<AsosiyModel> = repositori.arrayasosiy
    val arraytushuncha:ArrayList<QoshimchaModel> = repositori.arraytushuncha
    val arrayqoida:ArrayList<QoshimchaModel> = repositori.arrayqoida
    val arraymalumot:ArrayList<QoshimchaModel> = repositori.arraymalumot
    val malumot:String = repositori.malumot
    val arraytest:ArrayList<QuestionModel> = repositori.arrayTest
}