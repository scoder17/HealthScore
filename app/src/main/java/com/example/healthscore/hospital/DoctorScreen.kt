package com.example.healthscore.hospital

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.healthscore.data.Department
import com.example.healthscore.data.Doctor
import com.example.healthscore.data.GlobalVariable
import com.example.healthscore.data.doctors
import kotlinx.coroutines.launch

//@Preview(showSystemUi = true)
@Composable
fun DoctorScreen(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    var doctorName by remember {
        mutableStateOf("")
    }
    var doctorId by remember {
        mutableStateOf("")
    }
    var doctors by remember {
        mutableStateOf(mutableListOf<Doctor>())
    }
    LaunchedEffect(Unit) {
        doctors = getAllDoctorDataFromFireBase(GlobalVariable.department.deptId)
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = doctorName,
            onValueChange = { doctorName = it },
            label = { Text(text = "Doctor name") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = doctorId,
                onValueChange = { doctorId = it },
                label = { Text(text = "Doctor Id") },
                modifier = Modifier.weight(0.6f)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                modifier = Modifier
                    .weight(0.4f)
                    .align(Alignment.CenterVertically),
                onClick = {
                    doctors.add(
                        Doctor(doctorName, doctorId, GlobalVariable.department.deptId)
                    )
                    Log.d("happy", "DoctorScreen: $doctorId, $doctorName")
                    coroutineScope.launch {
                        addDoctorDataToFireBase(
                            Doctor(
                                doctorName,
                                doctorId,
                                GlobalVariable.department.deptId
                            )
                        )
                        doctorId=""
                        doctorName=""
                    }


                }

            ) {
                Text(text = "Add")
            }
        }
        LazyColumn(Modifier.padding(top = 30.dp)) {
            items(doctors) {
                DoctorItem(
                    doctor = it,
                    modifier = Modifier.padding(8.dp),
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun DoctorItem(
    doctor: Doctor,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { navController.navigate("add_patient_screen") },
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(text = doctor.doctorName, style = MaterialTheme.typography.titleMedium)
        }
    }
}