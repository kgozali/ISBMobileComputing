package com.isbmobilecomputing.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.isbmobilecomputing.api.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    override fun onStart() {
        super.onStart()

        Api.service<OtherService>()
            .getOtherService(7, 2020)
            .enqueue(object : Callback<BaseResponse<List<ShipmentSummary>>> {
                override fun onResponse(
                    call: Call<BaseResponse<List<ShipmentSummary>>>,
                    response: Response<BaseResponse<List<ShipmentSummary>>>
                ) {
                    tv1.text = response.body()?.data?.get(0)?.transactionStatus

                    response.body()?.data?.mapIndexed { index, shipmentSummary ->
                        tv1.text = shipmentSummary.transactionStatus
                        tv1.text = index.toString()
                    }
                }

                override fun onFailure(call: Call<BaseResponse<List<ShipmentSummary>>>, t: Throwable) {
                }
            })
    }

    companion object {
        const val USERNAME_TAG = "Use"
    }
}