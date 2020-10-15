package com.isbmobilecomputing.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.isbmobilecomputing.android.HomeActivity.Companion.USERNAME_TAG
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupView()
    }

    private fun setupView() {
        btnLogin.apply {
            text = getString(R.string.log_in)
            setOnClickListener {
                onButtonClick()
            }
        }
    }

    private fun onButtonClick() {
        if (etUsername.text.isNotBlank() && etPassword.text.isNotBlank()) {
            navigateToHomeActivity()
        } else {
            Toast.makeText(this@LoginActivity, "EMPTY USERNAME & PASSWORD", Toast.LENGTH_LONG).show()
        }
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        intent.putExtra(USERNAME_TAG, etUsername.text.toString())
        startActivity(intent)
    }
}