package com.example.project1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextInputContainer(
    label: String,
    text: String,
    onTextChange: (String) -> Unit,
    isPasswordContainer: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = {
            Text(
                text = label,
                fontSize = 16.sp,
                fontWeight = FontWeight.W300,
                color = Color(0XFF2E4057)
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0XFF94D1BE),
            focusedTextColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        // password visibility part
        visualTransformation = addVisualTransformation(isPasswordContainer, passwordVisible),
        trailingIcon = {
            if (isPasswordContainer) {
                PasswordIconClick(passwordVisible) { passwordVisible = !passwordVisible }
            }
        }
    )
}

fun addVisualTransformation(isPasswordContainer: Boolean, passwordVisible: Boolean): VisualTransformation {
    return if (isPasswordContainer && !passwordVisible) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }
}

@Composable
fun PasswordIconClick(passwordVisible: Boolean, onClick: () -> Unit) {
    Text(
        text = if (passwordVisible) "👁" else "👁‍🗨",
        modifier = Modifier
            .padding(end=10.dp)
            .width(20.dp)
            .clickable { onClick() }
    )
}