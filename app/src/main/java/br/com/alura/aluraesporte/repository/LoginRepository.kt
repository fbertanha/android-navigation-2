package br.com.alura.aluraesporte.repository

import android.content.SharedPreferences
import androidx.core.content.edit


private const val KEY_LOGADO = "key_logado"

class LoginRepository(private val preferences: SharedPreferences) {

    fun loga() {
        preferences.edit {
            putBoolean(KEY_LOGADO, true)
        }
    }

    fun estaLogado(): Boolean = preferences.getBoolean(KEY_LOGADO, false)
    fun desloga() {
        preferences.edit {
            putBoolean(KEY_LOGADO, false)
        }
    }

}
