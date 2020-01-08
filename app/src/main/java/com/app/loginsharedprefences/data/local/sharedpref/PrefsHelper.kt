package com.app.loginsharedprefences.data.local.sharedpref

import android.content.Context
import android.content.SharedPreferences

object PrefsHelper {

    private lateinit var prefs: SharedPreferences

    private const val PREFS_NAME = "params"


    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun read(key: String, value: String): String? {

        return prefs.getString(key, value)
    }


    fun write(key: String,value: String) {

        var editor= prefs.edit()
        editor.putString(key,value)
        editor.apply()

        }
    fun clear(){

        var editor= prefs.edit()
        editor.clear()
        editor.apply()
    }
    }
