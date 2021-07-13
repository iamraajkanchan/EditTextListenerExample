package com.example.edittextlistenerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initEditText()
    }

    private fun initEditText() {
        var randomTextCounter = 0

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(userInput: Editable?) {
                randomTextCounter = 12 - userInput.toString().length
                if (randomTextCounter == 0) {
                    tv_randomTextCount.text = ""
                } else {
                    tv_randomTextCount.text = "($randomTextCounter)"
                }
                if (!userInput!!.toString().equals(userInput.toString().toUpperCase(), false)) {
                    ed_randomText.setText(userInput.toString().toUpperCase())
                    ed_randomText.setSelection(userInput.toString().length)
                }
            }
        }

        ed_randomText.addTextChangedListener {
            textWatcher.afterTextChanged(it)
        }
    }
}