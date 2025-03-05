package com.example.project1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SignupScreen(navController : NavController){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    Surface(
        color = Color(0XFFDAF0EE),
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 30.dp)
                .padding(end = 30.dp)
                .padding(bottom = 100.dp)
        ) {
            Text(
                text = "Sign up",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                color = Color(0XFF2E4057),
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Spacer(modifier = Modifier.size(15.dp))
            TextInputContainer("Username", username) {username = it}
            Spacer(modifier = Modifier.size(15.dp))
            TextInputContainer("Password", password) {password = it}
            Spacer(modifier = Modifier.size(15.dp))
            TextInputContainer("Confirm Password", confirmPassword) {confirmPassword = it}
            Spacer(modifier = Modifier.size(15.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .padding(top = 5.dp)
            ) {
                Text(
                    "Already registered?",
                    fontWeight = FontWeight.W300
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    "Login here",
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.clickable { navController.navigate(Screens.Login.name)}
                )
            }
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    onClick = {
                        username = ""
                        password = ""
                        confirmPassword = ""
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0XFFF57A7A)
                    ),
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(
                        text = "Clear",
                        color = Color.Black
                    )
                }
                Button(
                    onClick = { navController.navigate(Screens.Login.name) },
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    Text(
                        text = "Signup",
                    )
                }

            }

        }
    }
}