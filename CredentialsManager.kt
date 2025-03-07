package com.example.project1

import android.content.Context

enum class AuthenticationStatus {
    SUCCESS,
    PASSWORD_MISMATCH,
    USERNAME_NOT_FOUND,
}

object CredentialsManager {
    private const val credentialUsername = "username"
    private const val credentialPassword = "password"
    private const val preferenceManager = "preference_manager"

    fun storeCredentials(context: Context, username: String, password:String) {
       val sharedPreferences = context.getSharedPreferences(preferenceManager, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(credentialUsername, username)
        editor.putString(credentialPassword, password)
        editor.apply()
    }

    fun isAuthenticated(context: Context, username: String, password: String): AuthenticationStatus {
        val sharedPreferences = context.getSharedPreferences(preferenceManager, Context.MODE_PRIVATE)
        val storedUsername = sharedPreferences.getString(credentialUsername, null)
        val storedPassword = sharedPreferences.getString(credentialPassword, null)

        return when {
            storedUsername == username && storedPassword == password -> AuthenticationStatus.SUCCESS
            storedUsername == username && storedPassword!= password -> AuthenticationStatus.PASSWORD_MISMATCH
            else -> AuthenticationStatus.USERNAME_NOT_FOUND

        }
    }
}