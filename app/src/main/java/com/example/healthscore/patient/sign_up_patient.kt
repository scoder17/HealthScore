package com.example.healthscore.patient

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthscore.R
import com.example.healthscore.data.PatientData

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Sign_up_patient() {
    val focusManager = LocalFocusManager.current

    var userMail by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var iniPassword by remember { mutableStateOf("") }
    var cnfPassword by remember { mutableStateOf("") }
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
        Spacer(modifier = Modifier.padding(30.dp))
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text(text = "Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = userMail,
            onValueChange = { userMail = it },
            label = { Text(text = "Email address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
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
                .padding(10.dp)
        )
        OutlinedTextField(
            value = cnfPassword,
            onValueChange = { cnfPassword = it },
            label = { Text(text = "Confirm Password") },
            visualTransformation = if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        TextButton(modifier = Modifier.align(Alignment.Start), onClick = { /*TODO*/ }) {
            Text(text = "Already have an account?")
        }
        Button(
            onClick = {
                if(iniPassword==cnfPassword){
                      val patientData=PatientData(userName,userMail,iniPassword, mutableListOf())
                      addDataToFireBase(patientData)
                }
                else{
                    Log.d(TAG, "Sign_up_patient: Password Mismatched")
                }
            },
            modifier = Modifier.size(180.dp, 50.dp)
        ) {
            Text(text = "Sign Up", fontSize = 18.sp)
        }

    }
}