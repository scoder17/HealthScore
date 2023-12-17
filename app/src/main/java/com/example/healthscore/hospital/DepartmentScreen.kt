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
import com.example.healthscore.data.GlobalVariable
import kotlinx.coroutines.launch


//@Preview(showSystemUi = true)
@Composable
fun DepartmentScreen(navController: NavHostController) {
    var departmentName by remember {
        mutableStateOf("")
    }
    var departmentIds = GlobalVariable.hospital.departmentId
    val coroutineScope = rememberCoroutineScope()

    var departments by remember {
        mutableStateOf(mutableListOf<Department>())
    }
    LaunchedEffect(Unit){
        Log.d("Error", "DepartmentScreen: ${GlobalVariable.hospital.hospitalId}")
        departments=getAllDepartmentDataFromFireBase(GlobalVariable.hospital.hospitalId)
    }
    var departmentId by remember {
        mutableStateOf("")
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = departmentName,
            onValueChange = { departmentName = it },
            label = { Text(text = "Department name") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = departmentId,
                onValueChange = { departmentId = it },
                label = { Text(text = "Department Id") },
                modifier = Modifier.weight(0.6f)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                modifier = Modifier
                    .weight(0.4f)
                    .align(Alignment.CenterVertically),
                onClick = {
                    departments.add(
                        Department(departmentName, departmentId,GlobalVariable.hospital.hospitalId)
                    )
                    departmentIds.add(departmentId)
                    coroutineScope.launch {
                        addDepartmentDataToFireBase(Department(departmentName,departmentId,GlobalVariable.hospital.hospitalId))
                    }
                    departmentId=""
                    departmentName=""
                }

            ) {
                Text(text = "Add")
            }
        }
        LazyColumn(Modifier.padding(top = 30.dp)) {
            items(departments) {
                DepartmentItem(
                    department = it,
                    modifier = Modifier.padding(8.dp),
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun DepartmentItem(
    department: Department,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { navController.navigate("doctor_screen") },
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Text(text = department.deptName, style = MaterialTheme.typography.titleMedium)
        }
    }
}