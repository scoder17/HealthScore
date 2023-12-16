package com.example.healthscore.patient

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Abc
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.outlined.Bloodtype
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.HealthScoreTheme
import com.example.healthscore.data.VitalsData

@Composable
fun VitalsScreen() {
    var item = VitalsData.vitalData
    Column(modifier = Modifier.padding(top=65.dp)) {
        Text(text = "Vitals")
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
                    vital = it.vital,
                    modifier = Modifier.padding(bottom = 16.dp, end = 16.dp)
                )
            }
        }
    }

}

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    value: String,
    unit: String,
    icon: ImageVector,
    vital: String,
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
        Text(text = vital, modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom=8.dp))
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun VitalScreenPreview() {
    HealthScoreTheme {
        VitalsScreen()
    }

}