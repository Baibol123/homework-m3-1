package com.example.homework_m2_6

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewWelcome: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.editTextText)
        editTextPassword = findViewById(R.id.editTextText2)
        buttonLogin = findViewById(R.id.button)
        textViewWelcome = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)


        buttonLogin.setOnClickListener {
            validateCredentials()
        }



        editText = findViewById(R.id.editTextText)
        button = findViewById(R.id.button)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                if (!charSequence.isNullOrBlank()) {
                    button.setBackgroundColor(resources.getColor(R.color.orange))
                } else {
                    button.setBackgroundColor(resources.getColor(R.color.gray))
                }
            }

            override fun afterTextChanged(editable: Editable?) {
            }
        })






    }
    fun validateCredentials() {
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        if (email == "admin" && password == "admin") {
            showToast("Вы успешно зарегистрировались")
            editTextEmail.visibility = View.GONE
            editTextPassword.visibility = View.GONE
            buttonLogin.visibility = View.GONE
            textView2.visibility = View.GONE
            textView3.visibility = View.GONE

        } else {
            showToast("Неправильный логин или пароль")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}