package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand:Double = 0.0
    private var operation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultText)
    }

    fun numberClick (clickedView: View) {
        if (clickedView is TextView) {
            var result = resultTextView.text.toString()
            val number = clickedView.text.toString()

            if (result == "0") {
                result = ""
            }

            resultTextView.text = number
        }
    }
    fun operationClick (clickedView: View) {
        if (clickedView is TextView) {
            val number = clickedView.text.toString()
            var operand = resultTextView.text.toString()
            this.operand = operand.toDouble()
            operation = clickedView.text.toString()

            resultTextView.text = number

        }
    }
        fun equalsClick(clickedView: View) {
            val secOperand = resultTextView.text.toString().toDouble()
            when (operation) {
                "+" -> resultTextView.text = (operand + secOperand).toString()
                "-" -> resultTextView.text = (operand - secOperand).toString()
                "/" -> resultTextView.text = (operand / secOperand).toString()
                "*" -> resultTextView.text = (operand * secOperand).toString()
            }
        }

        fun clearAll(clickedView: View) {
            resultTextView.text = ""
        }

        fun delFun(clickedView: View) {
            val length = resultTextView.length()
            if (length > 0)
                resultTextView.text = resultTextView.text.subSequence(0, length - 1)
        }
    }
