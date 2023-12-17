package com.example.healthscore.patient

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthscore.R
import com.example.healthscore.data.GlobalVariable


@Composable
fun ProfileScreen() {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){

            Card {
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.padding(28.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){

                Text(
                    GlobalVariable.User.patientName,
                    fontSize = 35.sp
                )
                Text(
                    GlobalVariable.User.email,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {}) {
                    Text(text = "Sign out")
                }
            }


    }
}