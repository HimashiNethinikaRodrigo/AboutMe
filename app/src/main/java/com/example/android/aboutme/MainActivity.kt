package com.example.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDone.setOnClickListener {
            clickHandlerFunction(it)
        }

        textViewNickName.setOnClickListener {
            updateNickName(it)
        }
    }

    private fun clickHandlerFunction(view: View) {
        textViewNickName.text = editTextNickName.text
        textViewNickName.visibility = View.VISIBLE
        buttonDone.visibility = View.GONE
        editTextNickName.visibility = View.GONE
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
            view.windowToken,
            0
        )
    }

    private fun updateNickName(view: View) {
        buttonDone.visibility = View.VISIBLE
        editTextNickName.visibility = View.VISIBLE
        textViewNickName.visibility = View.GONE
        editTextNickName.requestFocus()
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(
            editTextNickName,
            0
        )
    }

}