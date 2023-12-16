package com.example.healthscore.patient

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.healthscore.R
import com.example.healthscore.data.PatientData

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Sign_up_patient() {
    val focusManager = LocalFocusManager.current
    val navController= rememberNavController ()
    var userMail by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var iniPassword by remember { mutableStateOf("") }
    var cnfPassword by remember { mutableStateOf("") }
    var userGender by remember { mutableStateOf("") }
    var userAge by remember { mutableStateOf("") }
    var showPassword by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Patient Sign Up", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = userAge,
            onValueChange = { userAge = it },
            label = { Text(text = "Age") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = userGender,
            onValueChange = { userGender = it },
            label = { Text(text = "Enter Gender") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = userMail,
            onValueChange = { userMail = it },
            label = { Text(text = "Email address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        OutlinedTextField(
            value = iniPassword,
            onValueChange = { iniPassword = it },
            label = { Text(text = "Enter Password") },
            visualTransformation = if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
            trailingIcon = {
                val (icon, iconColor) =
                    if (showPassword) {
                        Pair(
                            Icons.Filled.Visibility,
                            colorResource(id = R.color.black)
                        )
                    } else {
                        Pair(
                            Icons.Filled.VisibilityOff,
                            colorResource(id = R.color.black)
                        )
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = cnfPassword,
            onValueChange = { cnfPassword = it },
            label = { Text(text = "Confirm Password") },
            visualTransformation = if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        )
        TextButton(modifier = Modifier.align(Alignment.Start), onClick = { /*TODO*/ }) {
            Text(text = "Already have an account?", modifier = Modifier.padding(bottom = 10.dp))
        }
        Button(
            onClick = {
                if (iniPassword == cnfPassword) {
                    val patientData = PatientData(
                        userName, userMail, iniPassword, userAge, userGender,
                        mutableListOf(), mutableListOf()
                    )
                    addDataToFireBase(patientData)
                } else {
                    Log.d(TAG, "Sign_up_patient: Password Mismatched")
                }
            },
            modifier = Modifier.size(180.dp, 50.dp)
        ) {
            Text(text = "Sign Up", fontSize = 18.sp)
        }

    }
}