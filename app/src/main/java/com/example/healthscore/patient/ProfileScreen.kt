package com.example.healthscore.patient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.HealthScoreTheme


@Composable
fun ProfileScreen() {
    Column{
        Row{
            Text(
                text="Adarsh",

            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPrev() {
    HealthScoreTheme {
        ProfileScreen()
    }
}