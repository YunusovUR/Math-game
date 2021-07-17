package com.yunusovur.mathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mathgame.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var number1 = 0
    var number2 = 0
    var simple = 0
    var answer = 0
    var inputAnswer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random()

        button.setOnClickListener{
            inputAnswer = text2.text.toString().toInt()
            if(inputAnswer == answer){
                Toast.makeText(this, "To`gri 🎁🎈🎉", Toast.LENGTH_SHORT).show()

            } else{
                Toast.makeText(this, "Noto'g'ri ❌", Toast.LENGTH_SHORT).show()
            }
            random()
            text2.text.clear()
        }

    }

    fun random(){
        number1 = Random().nextInt(30)
        number2 = Random().nextInt(30)
        simple = Random().nextInt(4)

        print()
    }

    fun print() {
        when(simple){
            0-> {
                answer = number1+number2
                text1.text = "$number1+$number2 = "
            }
            1-> {
                answer = number1-number2
                text1.text = "$number1-$number2 = "
            }
            2-> {
                answer = number1*number2
                text1.text = "$number1*$number2 = "
            }
            3-> {
                try {
                    answer = number1 / number2
                    text1.text = "$number1/$number2 = "
                } catch (e:Exception){
                    random()
                }
            }
        }
    }
}