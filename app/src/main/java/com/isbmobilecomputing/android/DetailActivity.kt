package com.isbmobilecomputing.android

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.default_toolbar.*

class DetailActivity : AppCompatActivity() {
    private val mToolbar: Toolbar by lazy {
        findViewById<View>(R.id.toolbar) as Toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tvTitle.text = "Kevin"
        ivBack.setOnClickListener {
            this.onBackPressed()
        }
    }
}