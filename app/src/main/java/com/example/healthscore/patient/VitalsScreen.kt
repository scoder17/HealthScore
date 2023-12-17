package com.example.healthscore.patient

import com.google.gson.Gson
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.HealthScoreTheme
import com.example.healthscore.data.AccessData
import com.example.healthscore.data.ResponseData
import com.example.healthscore.data.VitalData
import com.example.healthscore.data.VitalsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Composable
fun VitalsScreen() {
    val csecretPart="iNssdGZSSfsmS9lzireKNelKNKDNQ"
    val clsecret ="$2a$10$$csecretPart/octZGZ.qh9nGy1u7St2ChC2"
    var result by remember {mutableStateOf("Loading..")}
    val apiUrl = "https://hackathon.hsdevonline.com/HSLogin/oauth/token?grant_type=password&username=9821710137&password=0000&hospCode=CSOFTSUPPORT&client_secret=$clsecret&client_id=hackathon"
//    var result2 by remember {mutableStateOf("")}
    var result2 by remember { mutableStateOf<Any?>(null) }
    val apiUrl2 = "https://hackathon.hsdevonline.com/HS/mobile/V2/patientVitals"
    LaunchedEffect(Unit){
        result=fetchData(apiUrl)
        result2=fetchData2(apiUrl2, result, patientEId = 0)
//        var code = result2.data.firstOrNull()?.code ?: "Code not found"
//        var apiResponse = result2 as? ResponseData
//        var code = apiResponse?.data?.firstOrNull()?.name ?: "Name not found"
        val responseData = result2 as? ResponseData
        val name = responseData?.data?.firstOrNull()?.name ?: null
        // Use the 'code' variable as needed
        result2 = name
    }
    Log.d(TAG, "acessToken obtained: $result")
    Log.d(TAG, "vitals obtained: $result2")


    var item = VitalsData.vitalData
    Column(modifier = Modifier.padding(top=65.dp)) {
        Text(text = "Vitals")
        Text(text = "$result2")
        Text(text = "Here are your last recorded vitals")
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = 16.dp, start = 16.dp)
        ) {
            items(item) {
                GridItem(
                    value = it.value,
                    unit = it.unit,
                    icon = it.icon,
                    name = it.name,
                    modifier = Modifier.padding(bottom = 16.dp, end = 16.dp)
                )
            }
        }
    }

}

suspend fun fetchData(apiUrl: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val url = URL(apiUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            Log.d(TAG, "fetchData: I am working machaaa1")
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    Log.d(TAG, "fetchData: I am working machaaa2")
                    response.append(line)
                }
                reader.close()
                Log.d("API_RESPONSE", response.toString())
                // Access the specific parameter of the response
//                response.toString()
                val gson = Gson()
                val dataObject = gson.fromJson(response.toString(), AccessData::class.java)

                // Access the specific parameter of the response
                val specificData = dataObject.access_token
                specificData
            } else {
                "nothing"
            }
        } catch (e: Exception) {
            "Error: jai mata di ${e.message}"
        }
    }
}

suspend fun fetchData2(apiUrl2: String, authToken: String, patientEId: Int): Any {
    return withContext(Dispatchers.IO) {
        try {
            val url = URL(apiUrl2)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Authorization", "Bearer $authToken")
            Log.d(TAG, "fetchData: I am working for vital details machaaa1")
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    Log.d(TAG, "fetchData2: I am working vital details machaaa2")
                    response.append(line)
                }
                reader.close()
//                Log.d("API_RESPONSE", response.toString())
//                // Access the specific parameter of the response
                Log.d(TAG, "fetchData2: ${response.toString()}")

//                response.toString()
                  response
//                val gson = Gson()
//                val dataObject = gson.fromJson(response.toString(), ResponseData::class.java)
//                Log.d(TAG, "fetchData2: $dataObject")
                // Access the specific parameter of the response
//                val specificData = dataObject.data
//                specificData
            } else {
                "nothing part 2"
            }
        } catch (e: Exception) {
            "Error: jai mata di part2 ${e.message}"
        }
    }
}

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    value: String,
    unit: String,
    icon: ImageVector,
    name: String,
) {
    Card(modifier=modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                Text(text = value, style = MaterialTheme.typography.displayMedium)
                Text(
                    text = unit,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .align(Alignment.Bottom),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Image(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .align(Alignment.CenterVertically),
                )
            }
        }
        Text(text = name, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(bottom = 8.dp))
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun VitalScreenPreview() {
    HealthScoreTheme {
        VitalsScreen()
    }

}