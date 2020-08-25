package com.example.aboutme

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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


    }
}