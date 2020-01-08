package com.app.loginsharedprefences.loginactivity

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.loginsharedprefences.data.local.sharedpref.PrefsHelper
import com.app.mvvm_recyclerview.data.model.ErrorHandler

/**
 * @author Gautam Mittal
 * 6/1/20
 */
class LoginViewModel:ViewModel()
{

    var emailaddress = MutableLiveData<String>()
    var errorHandler=MutableLiveData<ErrorHandler>()

    init{
        emailaddress.value=""
    }




    fun onClick()
    {

        if (TextUtils.isEmpty(emailaddress.value))
        {

            errorHandler.value=ErrorHandler("Please Enter Value",0)

        }
        else
        {
            errorHandler.value= ErrorHandler("Welcome",1)



        }

    }

}