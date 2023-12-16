package com.example.healthscore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.HealthScoreTheme
//import com.example.healthscore.ui.theme.HealthScoreTheme

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.welcome),
//            contentDescription = "welcome",
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            contentScale = ContentScale.Crop
//        )
        Spacer(modifier = Modifier.padding(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Continue as a", style = MaterialTheme.typography.bodyLarge)
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(16.dp)) {
                Text(text = "Patient")
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(16.dp)) {
                Text(text = "Hospital")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    HealthScoreTheme {
        WelcomeScreen()
    }
}