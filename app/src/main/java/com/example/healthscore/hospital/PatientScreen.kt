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
import com.example.healthscore.data.Doctor
import com.example.healthscore.data.GlobalVariable
import com.example.healthscore.data.Patient
import com.example.healthscore.data.patients
import com.example.healthscore.patient.getPatientDataFromFireBase
import kotlinx.coroutines.launch

//@Preview(showSystemUi = true)
@Composable
fun PatientScreen(navController: NavHostController){
    val coroutineScope = rememberCoroutineScope()
    var patientName by remember {
        mutableStateOf("")
    }
    var patientId by remember {
        mutableStateOf("")
    }
    var patients by remember {
        mutableStateOf(mutableListOf<Patient>())
    }
    LaunchedEffect(Unit) {
        patients = getAllPatientDataFromFireBase(GlobalVariable.doctor.doctorId)
    }
    Column (
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = patientName,
            onValueChange = {patientName = it},
            label = { Text(text = "Patient name") },
            modifier= Modifier.fillMaxWidth()
        )
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            OutlinedTextField(
                value = patientId,
                onValueChange = {patientId = it},
                label = { Text(text = "Patient Id") },
                modifier= Modifier.weight(0.6f)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                modifier = Modifier.weight(0.4f).align(Alignment.CenterVertically),
                onClick = {
                    patients.add(
                        Patient(patientName, patientId, GlobalVariable.doctor.doctorId)
                    )

                    coroutineScope.launch {
                        addPatientDataToFireBase(
                            Patient(
                                patientName,
                                patientId,
                                GlobalVariable.doctor.doctorId
                            )
                        )
                        patientId=""
                        patientName=""
                    }
                }

            ) {
                Text(text = "Add")
            }
        }
        LazyColumn(Modifier.padding(top = 30.dp)){
            items(patients){
                PatientItem(
                    patient = it,
                    modifier= Modifier.padding(8.dp),
                    navController=navController
                )
            }
        }
    }

}
@Composable
fun PatientItem(
    patient: Patient,
    modifier: Modifier = Modifier,
    navController: NavHostController
){

    Card(modifier = modifier
        .fillMaxWidth()
        .clickable {
            GlobalVariable.patient=patient
            navController.navigate("patient_update_screen")},
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
            Text(text =patient.patientName, style = MaterialTheme.typography.titleMedium)
        }
    }
}