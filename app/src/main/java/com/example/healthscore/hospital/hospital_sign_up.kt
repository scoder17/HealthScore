package com.example.healthscore.hospital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthscore.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Sign_up_hospital() {
    val focusManager = LocalFocusManager.current
    val hspMail = remember { mutableStateOf(TextFieldValue()) }
    val hspId = remember { mutableStateOf(TextFieldValue()) }
    val iniPasswordHsp = remember { mutableStateOf(TextFieldValue()) }
    val cnfPasswordHsp = remember { mutableStateOf(TextFieldValue()) }
    val showPassword = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Hospital Sign Up", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(30.dp))
        OutlinedTextField(
            value = hspId.value,
            onValueChange = { hspId.value },
            label = { Text(text = "Hospital ID") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = hspMail.value,
            onValueChange = { hspMail.value },
            label = { Text(text = "Email address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = iniPasswordHsp.value,
            onValueChange = { iniPasswordHsp.value },
            label = { Text(text = "Enter Password") },
            visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val (icon, iconColor) =
                    if (showPassword.value) {
                        Pair(
                            Icons.Filled.Visibility,
                            colorResource(id = R.color.black)
                        )
                    }
                    else{
                        Pair(
                            Icons.Filled.VisibilityOff,
                            colorResource(id = R.color.black)
                        )
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = cnfPasswordHsp.value,
            onValueChange = { cnfPasswordHsp.value },
            label = { Text(text = "Confirm Password") },
            visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val (icon, iconColor) =
                    if (showPassword.value) {
                        Pair(
                            Icons.Filled.Visibility,
                            colorResource(id = R.color.black)
                        )
                    }
                    else{
                        Pair(
                            Icons.Filled.VisibilityOff,
                            colorResource(id = R.color.black)
                        )
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        TextButton(modifier = Modifier.align(Alignment.Start), onClick = { /*TODO*/ }) {
            Text(text = "Already have an account?")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(180.dp, 50.dp)
        ) {
            Text(text = "Sign Up", fontSize = 18.sp)
        }

    }
}