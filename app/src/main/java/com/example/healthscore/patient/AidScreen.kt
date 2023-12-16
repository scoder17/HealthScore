package com.example.healthscore.patient

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthscore.data.Aid
import com.example.healthscore.data.aids

@Preview
@Composable
fun AidScreen(modifier: Modifier = Modifier.safeContentPadding()) {
    LazyColumn(modifier = modifier.padding(top = 65.dp, bottom = 65.dp)) {
        items(aids) {
            AidItem(
                aid = it,
                modifier=Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AidItem(
    aid: Aid,
    modifier: Modifier = Modifier,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(id = aid.heading), style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.weight(1f))
                AidItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }

            if (expanded) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Text(
                        text = stringResource(id = aid.body),
                        modifier.padding(4.dp),
                        lineHeight = 20.sp
                    )
                }

            }
        }
    }
}

@Composable
private fun AidItemButton(
    expanded:Boolean,
    onClick:()->Unit,
    modifier: Modifier=Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(imageVector =if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = null)
    }

}