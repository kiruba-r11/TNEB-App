package com.example.tnebapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var consumedUnits = -1
            try {
                var currentUnits = editText2.text.toString().toInt()
                var previousUnits = editText.text.toString().toInt()
                consumedUnits = currentUnits - previousUnits
                if(consumedUnits < 0) {
                    textView3.text = "-"
                    textView5.text = "-"
                    Toast.makeText(this, "Enter a valid input", Toast.LENGTH_SHORT).show()
                }
                else {
                    textView5.text = consumedUnits.toString()
                    var cost = if(consumedUnits <= 100)
                        0.0
                    else if(consumedUnits <= 200)
                       1.50 * (consumedUnits) - 130
                    else if(consumedUnits <= 500)
                        230 + 3 * (consumedUnits - 200)
                    else
                        1780 + 6.60 * (consumedUnits - 500)
                    textView3.text = cost.toString()
                }
            }
            catch(e: NumberFormatException) {
                Toast.makeText(this, "Enter a valid input", Toast.LENGTH_SHORT).show()
            }
        }
    }

}