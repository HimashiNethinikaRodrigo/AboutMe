package com.example.android.aboutme

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDone.setOnClickListener {
            clickHandlerFunction(it)
        }
    }

    private fun clickHandlerFunction(view: View) {
        textViewNickName.text = editTextNickName.text
        textViewNickName.visibility = View.VISIBLE
        buttonDone.visibility = View.GONE
        editTextNickName.visibility = View.GONE
    }
}