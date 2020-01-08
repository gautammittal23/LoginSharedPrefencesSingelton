package com.app.loginsharedprefences.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.loginsharedprefences.R
import com.app.loginsharedprefences.data.local.sharedpref.PrefsHelper
import com.app.loginsharedprefences.loginactivity.LoginActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        PrefsHelper.init(this)

        var name=PrefsHelper.read("email","")

        txtviewtitle.setText(name)

        btnlogout.setOnClickListener { logout() }
    }

     fun logout() {
        PrefsHelper.clear()

        startActivity( Intent(this,LoginActivity::class.java))
    }


}
