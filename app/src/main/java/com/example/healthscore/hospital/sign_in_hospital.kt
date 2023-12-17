package com.example.healthscore.hospital

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose.HealthScoreTheme
import com.example.healthscore.R
import com.example.healthscore.data.GlobalVariable
import com.example.healthscore.patient.TAG
import kotlinx.coroutines.launch


@Composable
fun Sign_in_hospital(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    var hospitalEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.healthscore_logo), contentDescription = "",Modifier.height(120.dp).width(120.dp))
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Hospital Sign in", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(30.dp))
        OutlinedTextField(value = hospitalEmail,
            onValueChange = { hospitalEmail = it },
            label = { Text(text = "Hospital Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(value = userPassword,
            onValueChange = { userPassword = it },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        TextButton(modifier = Modifier.align(Alignment.Start), onClick = {
                navController.navigate("hospital_sign_up")
        }) {
            Text(text = "Register Yourself")
        }
        Button(
            onClick = {
                coroutineScope.launch {
                    val res = getHospitalDataFromFireBase(hospitalEmail)
                    if (res.password == userPassword && !res.password.isEmpty() && !userPassword.isEmpty()) {
                        Log.d(TAG, "Sign_in_hospital: Success")
                        GlobalVariable.hospital = res
                        navController.navigate("department_screen")
                    } else Log.d(TAG, "Sign_in_patient: Error")
                }

            }, modifier = Modifier.size(180.dp, 50.dp)
        ) {
            Text(text = "Sign In", fontSize = 18.sp)
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInHospitalPrev() {
    HealthScoreTheme {
//        Sign_in_hospital()
//
    }
}