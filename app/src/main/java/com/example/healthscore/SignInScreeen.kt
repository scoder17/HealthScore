package com.example.healthscore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthscore.ui.theme.HealthScoreTheme

@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeText()
        Spacer(modifier = Modifier.padding(30.dp))
        InputFields()
    }

}

@Composable
fun WelcomeText(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth(),horizontalAlignment = Alignment.Start) {
        Text(text = "Welcome,", style = MaterialTheme.typography.displayMedium)
        Text(text = "Sign in to continue", style = MaterialTheme.typography.headlineSmall)
    }

}

@Composable
fun InputFields(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = "", onValueChange = {}, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clip(RoundedCornerShape(30.dp)),
            label ={
                Text(text = "Email")
            }
            )
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .clip(RoundedCornerShape(30.dp)),
            label ={
                Text(text = "Password")
            }
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sign In")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInScreenPrev() {
    HealthScoreTheme {
        SignInScreen()
    }
}