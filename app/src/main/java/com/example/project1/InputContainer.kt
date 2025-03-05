package com.example.project1

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextInputContainer(label : String, text: String, onTextChange : (String) -> Unit){
    OutlinedTextField(
        value = text,
        onValueChange = {onTextChange(it)},
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
            .padding(2.dp)
    )
}
