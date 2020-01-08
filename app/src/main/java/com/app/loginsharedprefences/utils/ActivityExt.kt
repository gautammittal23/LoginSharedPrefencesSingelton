package com.app.loginsharedprefences.utils

import android.app.Activity
import android.widget.Toast

/**
 * @author Gautam Mittal
 * 7/1/20
 */


fun Activity.showtoast(message:String)
{
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}