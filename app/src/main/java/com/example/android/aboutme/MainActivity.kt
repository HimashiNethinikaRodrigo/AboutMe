package com.example.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Himashi Rodrigo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.buttonDone.setOnClickListener {
            clickHandlerFunction(it)
        }

        binding.textViewNickName.setOnClickListener {
            updateNickName(it)
        }
    }

    private fun clickHandlerFunction(view: View) {
        binding.apply {
            textViewNickName.text = editTextNickName.text
            textViewNickName.visibility = View.VISIBLE
            buttonDone.visibility = View.GONE
            editTextNickName.visibility = View.GONE
        }
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
            view.windowToken,
            0
        )
    }

    private fun updateNickName(view: View) {
        binding.apply {
            buttonDone.visibility = View.VISIBLE
            editTextNickName.visibility = View.VISIBLE
            textViewNickName.visibility = View.GONE
            editTextNickName.requestFocus()
        }

        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(
            editTextNickName,
            0
        )
    }

}