package com.example.aboutme

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //val doneButton:Button = findViewById<Button>(R.id.done_button)

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun addNickName(view: View) {
        //val nickNameEditText = findViewById<EditText>(R.id.nickname_edit)
        //val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            nicknameText.text = nicknameEdit.text
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
        }

        //close soft keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
}