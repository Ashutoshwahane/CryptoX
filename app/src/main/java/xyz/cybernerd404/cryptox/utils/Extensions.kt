package xyz.cybernerd404.cryptox.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import xyz.cybernerd404.cryptox.R

fun debug(message: String){
    Log.d("debug", message)
}

fun showToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}