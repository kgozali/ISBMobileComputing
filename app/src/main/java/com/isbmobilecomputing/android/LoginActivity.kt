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

    override fun onResume() {
        super.onResume()
        if (ApplicationData.isLogin) navigateToHomeActivity()
    }

    private fun onButtonClick() {
        if (etUsername.text.isNotBlank() && etPassword.text.isNotBlank()) {
            navigateToHomeActivity()
        } else {
            Toast.makeText(this@LoginActivity, "EMPTY USERNAME & PASSWORD", Toast.LENGTH_LONG).show()
        }
    }

    private fun navigateToHomeActivity() {
        if (ApplicationData.isLogin) {
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        } else {
            ApplicationData.username = etUsername.text.toString()
            ApplicationData.isLogin = true
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}