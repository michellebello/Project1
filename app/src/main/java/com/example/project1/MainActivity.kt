package com.example.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project1Theme {
                val navController = rememberNavController()
                NavHost (
                    navController = navController,
                    startDestination = Screens.Login.name
                ){
                    composable(route = Screens.Login.name) {
                        LoginScreen(navController)
                    }
                    composable(route = Screens.Signup.name) {
                        SignupScreen(navController)
                    }
                    composable (route = Screens.Welcome.name){
                        WelcomeScreen(navController)
                    }
                }
            }
        }
    }
}

enum class Screens () {
    Login,
    Signup,
    Welcome
}

