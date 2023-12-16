package com.example.healthscore.hospital

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

//@Preview(showSystemUi = true)
@Composable
fun AddPatient(navController: NavHostController){
    var medicine by remember {
        mutableStateOf("")
    }
    var doctorNotes by remember {
        mutableStateOf("")
    }
//    var vitals by remember {
//        mutableStateOf("")
//    }
    Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Patient Name")
            Text(text = "Patient ID")
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = medicine,
            onValueChange = {medicine=it},
            singleLine = false,
            label = { Text(text = "Enter Medicine")}
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = doctorNotes,
            onValueChange = {doctorNotes=it},
            singleLine = false,
            label = { Text(text = "Suggestions")}
        )
        Button(
            modifier = Modifier.width(200.dp).padding(top=10.dp),
            onClick = { navController.navigate("add_patient_screen") },

        ) {
            Text(text = "Submit")
        }
    }
}