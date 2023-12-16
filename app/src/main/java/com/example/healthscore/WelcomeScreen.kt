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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthscore.hospital.Sign_in_hospital
import com.example.healthscore.patient.Sign_in_patient

@Composable
fun App(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "welcomeScreen"){
        composable("welcomeScreen"){
            WelcomeScreen(navController=navController)
        }
        composable("patient"){
            Sign_in_patient()
        }
        composable("hospital"){
            Sign_in_hospital()
        }
    }

}
@Composable
fun WelcomeScreen(navController: NavHostController) {
    var selectedOption by remember {
        mutableStateOf("")
    }

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
            Button(
                onClick = {
                          selectedOption="patient"
                    navController.navigate("patient")
                } ,
                modifier = Modifier.padding(16.dp))
            {
                Text(text = "Patient")
            }
            Button(onClick = {
                selectedOption="hospital"
                                navController.navigate("hospital")
                                },
                modifier = Modifier.padding(16.dp)) {
                Text(text = "Hospital")
            }
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun WelcomeScreenPreview() {
//    HealthScoreTheme {
//        WelcomeScreen()
//    }
//}