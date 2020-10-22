package com.isbmobilecomputing.android

import android.content.Context

object ApplicationData {
    lateinit var context: Context

    private val sharedPreferences: SharedPreferences by lazy {
        SharedPreferences("SHARED_PREF")
    }

    fun init(context: Context) {
        this.context = context
    }

    var username: String
        get() = sharedPreferences.getStringPref("NAME")
        set(value) {
            sharedPreferences.setStringPref("NAME", value)
        }

    var isLogin: Boolean
        get() = sharedPreferences.getBooleanPref("IS_LOGIN")
        set(value) {
            sharedPreferences.setBooleanPref("IS_LOGIN", value)
        }
}