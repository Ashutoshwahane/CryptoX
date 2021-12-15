package xyz.cybernerd404.cryptox.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import xyz.cybernerd404.cryptox.R
import xyz.cybernerd404.cryptox.model.BlockModel
import java.security.MessageDigest

fun debug(message: String){
    Log.d("debug", message)
}

fun showToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun hashString(input: BlockModel, algorithm: String): String {
    return MessageDigest
        .getInstance(algorithm)
        .digest("${input.hash}${input.message}".toByteArray())
        .fold("", { str, it -> str + "%02x".format(it) })
}