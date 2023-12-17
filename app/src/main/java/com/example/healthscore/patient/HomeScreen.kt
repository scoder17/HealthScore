package com.example.healthscore.patient

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthscore.data.DocNotes
import com.example.healthscore.data.GlobalVariable
import com.example.healthscore.data.Medicine

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var user=GlobalVariable.User
    var medicine by remember {
        mutableStateOf(mutableListOf<Medicine>())
    }
    var doctorNotes by remember {
        mutableStateOf(mutableListOf<DocNotes>())
    }
    LaunchedEffect(Unit ){
        doctorNotes= getAllDocNotesDataFromFireBase()
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
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF63BDC3), shape = RoundedCornerShape(size = 10.dp)),
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
                        Text(text = "Name", fontWeight = FontWeight.Bold, color = Color.Black)
                        Text(text = "Age", fontWeight = FontWeight.Bold, color = Color.Black)
                        Text(text = "Gender", fontWeight = FontWeight.Bold, color = Color.Black)
                        Text(text = "UID", fontWeight = FontWeight.Bold, color = Color.Black)
                    }
                    Column(
                        modifier.padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(text = user.patientName, fontWeight = FontWeight.Medium, color = Color.Black)
                        Text(text = user.age, fontWeight = FontWeight.Medium, color = Color.Black)
                        Text(text = user.gender, fontWeight = FontWeight.Medium, color = Color.Black)
                        Text(text = "ABHA XXXX", fontWeight = FontWeight.Medium, color = Color.Black)
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
                .padding(16.dp)
            , elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier.background(color = Color(0xFF63BDC3), shape = RoundedCornerShape(size = 10.dp))) {
                Text(
                    text = "ACTIVE", color = Color.White,
                    modifier = Modifier
                        .padding(top = 8.dp, end = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Green)
                        .padding(5.dp)
                        .align(Alignment.End),
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.labelMedium,

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
                            Text(text = "Hospital ID", fontWeight = FontWeight.Bold, color = Color.Black)
                            Text(text = "Hospital Name", fontWeight = FontWeight.Bold, color = Color.Black)
                            Text(text = "Doctor", fontWeight = FontWeight.Bold, color = Color.Black)
                            Text(text = "Symptoms", fontWeight = FontWeight.Bold, color = Color.Black)
                        }
                        Column(
                            modifier.padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Text(text = "HSP0123", fontWeight = FontWeight.Medium, color = Color.Black)
                            Text(text = "Sagar Hospital", fontWeight = FontWeight.Medium, color = Color.Black)
                            Text(text = "Dr. Adarsh", fontWeight = FontWeight.Medium, color = Color.Black)
                            Text(text = "Cold", fontWeight = FontWeight.Medium, color = Color.Black)
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
                .padding(16.dp)
                .border(width = 1.dp, color = Color(0xFF000000), shape = RoundedCornerShape(10.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {

                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    Text(text = "Prevention")
                   repeat(GlobalVariable.User.docNotes.size){
                        Text(text =GlobalVariable.User.docNotes[it] )
                    }
                }
            }
        }

    }
}
