package com.example.healthscore.hospital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Sign_in_hospital(){
    val userName = remember { mutableStateOf(TextFieldValue()) }
    val userPassword = remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Hospital Sign in", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(30.dp))
        OutlinedTextField(
            value = userName.value,
            onValueChange = {userName.value},
            label = { Text(text = "Patient ID") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = userPassword.value,
            onValueChange ={userPassword.value},
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        TextButton(modifier = Modifier.align(Alignment.Start),onClick = { /*TODO*/ }) {
            Text(text = "Forgot your Password?")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(180.dp,50.dp)
        ) {
            Text(text = "Sign In", fontSize = 18.sp)
        }

    }
}