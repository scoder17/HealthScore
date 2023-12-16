package com.example.healthscore.patient

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthscore.data.GlobalVariable

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var user=GlobalVariable.User
    val preventionList by remember {
        mutableStateOf(mutableListOf<String>())
    }
    Column(
        modifier = Modifier
//            .verticalScroll(rememberScrollState())
            .padding(top = 65.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

//        Patient ID card
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = modifier.padding(16.dp)
                ) {
                    Column(
                        modifier
                            .padding(10.dp)
                            .padding(end = 5.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top)
                    ) {
                        Text(text = "Name", fontWeight = FontWeight.Bold)
                        Text(text = "Age", fontWeight = FontWeight.Bold)
                        Text(text = "Gender", fontWeight = FontWeight.Bold)
                        Text(text = "UID", fontWeight = FontWeight.Bold)
                    }
                    Column(
                        modifier.padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(text = user.patientName, fontWeight = FontWeight.Medium)
                        Text(text = user.age, fontWeight = FontWeight.Medium)
                        Text(text = user.gender, fontWeight = FontWeight.Medium)
                        Text(text = "1DS21CS030", fontWeight = FontWeight.Medium)
                    }
                }
                Image(
                    imageVector = Icons.Filled.Person, contentDescription = null,
                    modifier
                        .height(128.dp)
                        .width(128.dp)
                        .padding(end = 35.dp)
                )
            }
        }



        Text(
            text = "Current Medication",
            modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )



        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column() {
                Text(
                    text = "ACTIVE", color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, end = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Green)
                        .padding(5.dp)
                        .align(Alignment.End),
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.labelMedium
                )
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
                    ) {
                        Column(
                            modifier
                                .padding(10.dp)
                                .padding(end = 5.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top)
                        ) {
                            Text(text = "Hospital ID", fontWeight = FontWeight.Bold)
                            Text(text = "Hospital Name", fontWeight = FontWeight.Bold)
                            Text(text = "Doctor", fontWeight = FontWeight.Bold)
                            Text(text = "Symptoms", fontWeight = FontWeight.Bold)
                        }
                        Column(
                            modifier.padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Text(text = "HSP0123", fontWeight = FontWeight.Medium)
                            Text(text = "Sagar Hospital", fontWeight = FontWeight.Medium)
                            Text(text = "Dr. Adarsh", fontWeight = FontWeight.Medium)
                            Text(text = "Cold", fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }

        Text(
            text = "Doctor Notes",
            modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {

                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Text(text = "Prevention")
                }
            }
        }

    }
}
