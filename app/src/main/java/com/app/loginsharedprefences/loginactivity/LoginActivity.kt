package com.app.loginsharedprefences.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.app.loginsharedprefences.R
import com.app.loginsharedprefences.data.local.sharedpref.PrefsHelper
import com.app.loginsharedprefences.databinding.ActivityMainBinding
import com.app.loginsharedprefences.utils.showtoast
import com.app.loginsharedprefences.welcome.WelcomeActivity
import com.app.mvvm_recyclerview.data.model.ErrorHandler

class LoginActivity : AppCompatActivity() {



    var loginViewModel:LoginViewModel?=null
    var mainBinding:ActivityMainBinding?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       PrefsHelper.init(this)
        var name=PrefsHelper.read("email","")



        if(!name.equals(""))
        {
            showtoast("Welcome Back")
            startActivity(Intent(this,WelcomeActivity::class.java))

        }
        else
        {
            showtoast("New User")
        }


        mainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        //factoryModel= FactoryModel(SharedPref)


        loginViewModel= ViewModelProviders.of(this).get<LoginViewModel>(LoginViewModel::class.java)
        mainBinding!!.lifecycleOwner = this
        mainBinding!!.login = loginViewModel


        loginViewModel!!.errorHandler.observe(this,
            Observer <ErrorHandler>{ t->

                when(t!!.errorField)
                {
                    0->
                    {
                        Toast.makeText(this,t.errorMessage, Toast.LENGTH_LONG).show()
                    }
                    1->
                    {
                        observe()
                    }
                }
            }
        )


    }

    fun observe(){

        loginViewModel!!.emailaddress.observe(this, Observer {

            var email=it.toString() // PreferenceHelper.
            PrefsHelper.write("email",email)
            showtoast(email)

            startActivity( Intent(this,WelcomeActivity::class.java))

        })
    }
}



