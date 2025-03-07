package com.example.project1

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController : NavController, context: Context) {
    Surface(
        color = Color(0XFFDAF0EE),
        modifier = Modifier.fillMaxSize(),
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                "Welcome!",
                fontSize = 40.sp,
                fontWeight = W600

            )
            Spacer(modifier = Modifier.size(40.dp))
            Button(
                onClick = {navController.navigate(Screens.Login.name)}
            ) {
                Text (
                    "Back to Login",
                    fontSize = 16.sp
                )
            }
        }

    }
}