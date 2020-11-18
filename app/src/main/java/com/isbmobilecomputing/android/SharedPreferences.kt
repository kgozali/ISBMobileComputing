package com.isbmobilecomputing.android

import android.content.Context
import androidx.core.content.edit

class SharedPreferences(tag: String) {
    private val pref by lazy {
        ApplicationData.context.getSharedPreferences(tag, Context.MODE_PRIVATE)
    }

    fun getStringPref(key: String): String {
        return pref.getString(key, "").orEmpty()
    }

    fun setStringPref(key: String, value: String, commit: Boolean = false) {
        pref.edit(commit) { putString(key, value) }
    }

    fun getBooleanPref(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    fun setBooleanPref(key: String, value: Boolean, commit: Boolean = false) {
        pref.edit(commit) { putBoolean(key, value) }
    }

    fun getInt(key: String): Int {
        return pref.getInt(key, 0)
    }

    fun setIntPref(key: String, value: Int, commit: Boolean = false) {
        pref.edit(commit) { putInt(key, value) }
    }
}