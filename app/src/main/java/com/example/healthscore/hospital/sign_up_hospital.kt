package com.example.healthscore.hospital

import android.util.Log
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.healthscore.R
import com.example.healthscore.data.HospitalData
import com.example.healthscore.data.PatientData
import com.example.healthscore.patient.TAG
import com.example.healthscore.patient.addDataToFireBase

//@Preview(showBackground = true, showSystemUi = true)
//
@Composable
fun Sign_up_hospital(navController: NavHostController) {
    var hspMail by remember { mutableStateOf("") }
    var hspName by remember { mutableStateOf("") }
    var hspId by remember { mutableStateOf("") }
    var iniPasswordHsp by remember { mutableStateOf("") }
    var cnfPasswordHsp by remember { mutableStateOf("") }
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
        Text(text = "Hospital Sign Up", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(30.dp))
        OutlinedTextField(
            value = hspName,
            onValueChange = { hspName = it },
            label = { Text(text = "Hospital Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = hspId,
            onValueChange = { hspId = it },
            label = { Text(text = "Hospital ID") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = hspMail,
            onValueChange = { hspMail = it },
            label = { Text(text = "Email address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = iniPasswordHsp,
            onValueChange = { iniPasswordHsp = it },
            label = { Text(text = "Enter Password") },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
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
            value = cnfPasswordHsp,
            onValueChange = { cnfPasswordHsp = it },
            label = { Text(text = "Confirm Password") },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
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
        TextButton(modifier = Modifier.align(Alignment.Start),
            onClick = {
                navController.navigate("hospital_sign_in")
            }) {
            Text(text = "Already have an account?")
        }
        Button(
            onClick = {
                if (iniPasswordHsp == cnfPasswordHsp && !iniPasswordHsp.isEmpty()) {
                    val hospitalData = HospitalData(hspName, hspId,hspMail, iniPasswordHsp, mutableListOf())
                    addHospitalDataToFireBase(hospitalData)
                    navController.navigate("hospital_sign_in")
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