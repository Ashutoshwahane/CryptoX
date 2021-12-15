package xyz.cybernerd404.cryptox.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences("currency", Context.MODE_PRIVATE)

    companion object {
        const val selectedCurrecy = "selectedCurrecy"
    }


    fun saveCurrency(currency: String) {
        val editor = prefs.edit()
        editor.putString(selectedCurrecy, currency)
        editor.apply()
    }


    fun fetchCurrency(): String? {
        return prefs.getString(selectedCurrecy, null)
    }
}