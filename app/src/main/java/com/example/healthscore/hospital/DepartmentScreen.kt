package com.example.healthscore.hospital

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthscore.data.Department
import com.example.healthscore.data.departments


@Preview(showSystemUi = true)
@Composable
fun DepartmentScreen(){
    var doctorName by remember {
        mutableStateOf("")
    }
    var doctorId by remember {
        mutableStateOf("")
    }
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedTextField(
                value = doctorName,
                onValueChange = {doctorName = it},
                label = {Text(text = "Doctor name")},
                modifier=Modifier.width(270.dp)
            )
            Button(
                onClick = { /*TODO*/ }

            ) {
                Text(text = "Add")
            }
        }
        LazyColumn(){
            items(departments){
                DepartmentItem(
                    department = it,
                    modifier=Modifier.padding(8.dp)
                )
            }
        }
    }

}
@Composable
fun DepartmentItem(
    department: Department,
    modifier:Modifier=Modifier
){

    Card(modifier = modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)) {
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text =department.deptName, style = MaterialTheme.typography.titleMedium)


//                AidItemButton(
//                    expanded = expanded,
//                    onClick = { expanded = !expanded }
//                )
            }

//            if (expanded) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//                    Text(
//                        text = stringResource(id = aid.body),
//                        modifier.padding(4.dp),
//                        lineHeight = 20.sp
//                    )
//                }
//
//            }
        }
    }
}