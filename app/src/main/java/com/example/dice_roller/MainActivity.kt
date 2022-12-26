package com.example.dice_roller

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
        val button = findViewById<Button>(R.id.button)
        val img =findViewById<ImageView>(R.id.imageView)
        img.setImageResource(R.drawable.dice_1)
        button.setOnClickListener {
            val toast = Toast.makeText(this, "Rolled", Toast.LENGTH_SHORT)
            toast.show()
//            val text:TextView=findViewById(R.id.textView)
//            text.text= (1..6).random().toString()
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val img:ImageView=findViewById(R.id.imageView)

        val die=when(diceRoll)
        {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        img.setImageResource(die)
     img.contentDescription="dice rolled"
    }

    class Dice(val sides: Int) {
        fun roll(): Int {
            val num = (1..6).random()
            return num
        }
    }


}


