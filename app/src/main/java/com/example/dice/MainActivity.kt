package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
//            Toast.makeText(this,"dice rolled",Toast.LENGTH_SHORT).show()
//            val textResultView:TextView=findViewById(R.id.textView)
//            textResultView.text="6"
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
//        val resultText: TextView = findViewById(R.id.textView)
//        resultText.text = dice.roll().toString()
        val resultImage:ImageView= findViewById(R.id.imageView2)
        val resultimage1:ImageView=findViewById(R.id.imageView3)
        val diceRoll1=dice.roll()
        val diceRoll2=dice.roll()
        val draw=when(diceRoll1){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }

        val draw1=when(diceRoll2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        resultImage.setImageResource(draw)
        resultImage.contentDescription=diceRoll1.toString()

        resultimage1.setImageResource(draw1)
        resultimage1.contentDescription=diceRoll2.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}