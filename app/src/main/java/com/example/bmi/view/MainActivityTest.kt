package com.example.bmi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.bmi.R
import com.example.bmi.databinding.ActivityMainTestBinding
import com.example.bmi.model.QuestionModel
import com.example.bmi.viewModel.AsosiyViewModel

class MainActivityTest : AppCompatActivity() {

    lateinit var arrayList: ArrayList<QuestionModel>
    val a = 1
    lateinit var questionModel: QuestionModel
    lateinit var asosiyViewModel:AsosiyViewModel
    var trueanswer=0
    var falseanswer=0
    var count = 0
    var cheked=true

    lateinit var binding:ActivityMainTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        asosiyViewModel = ViewModelProvider(this).get(AsosiyViewModel::class.java)

        binding.apply {
            textTitle.text = intent.getStringExtra("title")

            arrayList = asosiyViewModel.arraytest
            arrayList.shuffle()

            setQuestions()

            binding.apply {
                textviewnext.setOnClickListener {
                    setQuestions()
                }
                textviewoption1.setOnClickListener {
                    checkanswers(questionModel,textviewoption1)
                }
                textviewoption2.setOnClickListener {
                    checkanswers(questionModel,textviewoption2)
                }
                textviewoption3.setOnClickListener {
                    checkanswers(questionModel,textviewoption3)
                }
                textviewoption4.setOnClickListener {
                    checkanswers(questionModel,textviewoption4)
                }
            }

            toolbarBack.setOnClickListener {
                finish()
            }
        }
    }



    fun setQuestions() {
        binding.apply {
            checkanswerlimit()
            textviewquestion.text=questionModel.question
            val arraylist= arrayListOf(
                questionModel.option1,
                questionModel.option2,
                questionModel.option3,
                questionModel.option4,
            )
            arraylist.shuffle()
            textviewoption1.text = arraylist.get(0)
            textviewoption2.text = arraylist.get(1)
            textviewoption3.text = arraylist.get(2)
            textviewoption4.text = arraylist.get(3)
            clearcheckcolor()
            cheked=true
        }
    }

    fun checkanswerlimit() {

        if (count < arrayList.size) {
            questionModel=arrayList.get(count)
        }
        if (count==arrayList.size-1){
            binding.textviewnext.text="finish"
        }

        if (count==arrayList.size){
            endgame()
        }
        if (count==arrayList.size+1){
            restart()
        }
        count++

    }

    fun endgame(){
        binding.apply {
            linearlay1.visibility = View.GONE
            textviewnext.text="restart ?"
            textviewtrueorfalseanswer.visibility = View.VISIBLE

            textviewtrueorfalseanswer.text="True $trueanswer\nFalse $falseanswer\nBelgilanmagan ${arrayList.size-trueanswer-falseanswer}"

        }
    }

    fun restart(){
        count=0
        setQuestions()
        trueanswer=0
        falseanswer=0
        binding.apply {
            linearlay1.visibility = View.VISIBLE
            textviewnext.text="next"
            textviewtrueorfalseanswer.visibility = View.GONE
        }
    }


    fun checkanswers(questionModel: QuestionModel,view: TextView){
        binding.apply {

            if (view.text.toString() == questionModel.answer){
                //showtoast(this@MainActivity,"true")
                checkcolor(true,view)
                if (cheked){
                    trueanswer++
                    cheked=false
                }
            }else{
                //showtoast(this@MainActivity,"false")
                checkcolor(false,view)
                if (cheked){
                    cheked=false
                    falseanswer++
                }

            }

        }
    }

    fun checkcolor(trueorfalse:Boolean,view: TextView){
        if (trueorfalse){
            view.background= ContextCompat.getDrawable(this@MainActivityTest,R.drawable.background_green)
        }else{
            view.background= ContextCompat.getDrawable(this@MainActivityTest,R.drawable.background_red)
        }
    }

    fun clearcheckcolor(){
        binding.apply {
            textviewoption1.background= ContextCompat.getDrawable(this@MainActivityTest,R.drawable.background_transparent)
            textviewoption2.background= ContextCompat.getDrawable(this@MainActivityTest,R.drawable.background_transparent)
            textviewoption3.background= ContextCompat.getDrawable(this@MainActivityTest,R.drawable.background_transparent)
            textviewoption4.background= ContextCompat.getDrawable(this@MainActivityTest,R.drawable.background_transparent)
        }
    }

}