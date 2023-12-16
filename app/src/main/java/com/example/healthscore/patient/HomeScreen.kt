package com.example.healthscore.patient

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
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
                        Text(text = "Aman Kumar", fontWeight = FontWeight.Medium)
                        Text(text = "21", fontWeight = FontWeight.Medium)
                        Text(text = "Male", fontWeight = FontWeight.Medium)
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

        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column() {
                Text(text = "ACTIVE")
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
                            Text(text = "Aman Kumar", fontWeight = FontWeight.Medium)
                            Text(text = "21", fontWeight = FontWeight.Medium)
                            Text(text = "Male", fontWeight = FontWeight.Medium)
                            Text(text = "1DS21CS030", fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }
    }
}
