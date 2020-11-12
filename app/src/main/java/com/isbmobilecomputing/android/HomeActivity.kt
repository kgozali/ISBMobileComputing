package com.isbmobilecomputing.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    private var username: String? = null
    private var password: String? = null

    lateinit var viewPagerAdapter: ViewPagerAdapter

    val listNames: List<String> = listOf("Bevan", "Jessica", "Ammar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, this.lifecycle)

        listNames.map {
            viewPagerAdapter.addFragment(Fragment1.init(it))
        }

        viewPager2.adapter = viewPagerAdapter
        viewPager2.offscreenPageLimit = 3

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = listNames[position]
        }.attach()
    }

    companion object {
        const val USERNAME_TAG = "Use"
    }
}