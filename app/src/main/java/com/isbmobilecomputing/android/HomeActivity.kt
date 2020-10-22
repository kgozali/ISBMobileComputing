package com.isbmobilecomputing.android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    private var username: String? = null
    private var password: String? = null
    private val applicationData = ApplicationData(this@HomeActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvUsername.text = getString(R.string.template_username_home, applicationData.username)

        tvGoBack.setOnClickListener {
            this.onBackPressed()
        }

        tvFinish.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
            this.finish()

            applicationData.username = "tes"
        }
    }

    companion object {
        const val USERNAME_TAG = "Use"
    }
}