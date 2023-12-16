package com.example.healthscore.patient

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.HealthScoreTheme

@Composable
fun MedicineScreen() {
    val medList by remember {
        mutableStateOf(mutableListOf<String>())
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Medications",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(10.dp))

            if (medList.isEmpty()) {
                Text(
                    text = "No Medications has been assigned to you by the doctor!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            } else {
                repeat(medList.size) {
                    Text(
                        text = medList[it], textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 20.sp
                    )
                    Divider(thickness = 4.dp)
                }

            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MedicineScreenComposable() {
    HealthScoreTheme {
        MedicineScreen()
    }
}