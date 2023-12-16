package com.example.healthscore.patient

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.HealthScoreTheme
import kotlinx.coroutines.launch


@Composable
fun Sign_in_patient(patientDataViewModel: PatientDataViewModel = viewModel()) {

    val coroutineScope = rememberCoroutineScope()
    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Patient Sign in", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.padding(30.dp))
        OutlinedTextField(
            value = userEmail,
            onValueChange = { userEmail = it },
            label = { Text(text = "Patient Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        OutlinedTextField(
            value = userPassword,
            onValueChange = { userPassword = it },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        TextButton(modifier = Modifier.align(Alignment.Start), onClick = { /*TODO*/ }) {
            Text(text = "Forgot your Password?")
        }
        Button(
            onClick = {
                coroutineScope.launch {
                    val res = getPatientDataFromFireBase(userEmail)
                if(res.password==userPassword)
                {
                    Log.d(TAG, "Sign_in_patient: Success")
                    GlobalVariable.User=res
                }
                else
                    Log.d(TAG, "Sign_in_patient: Error")
                }
            },
            modifier = Modifier.size(180.dp, 50.dp)
        ) {
            Text(text = "Sign In", fontSize = 18.sp)
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignInPreview() {
    HealthScoreTheme {
        Sign_in_patient()
    }

}