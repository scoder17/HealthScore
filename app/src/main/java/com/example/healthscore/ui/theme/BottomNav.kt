package com.example.healthscore.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthscore.data.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomNavBar(){
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),
        BottomNavigationItem(
            title = "Item1",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
            badgeCount = null
        ),BottomNavigationItem(
            title = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasNews = false,
            badgeCount = null
        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed{
                    index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = { selectedItemIndex=index },
                        label = {
                                Text(text = item.title)
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if(item.badgeCount != null){
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    }
                                    else if(item.hasNews){
                                        Badge ()
                                    }
                            }) {
                                Icon(
                                    imageVector =
                                    if(index == selectedItemIndex){
                                                                    item.selectedIcon
                                                                  }
                                    else
                                        item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        })
                }
            }
        }
    ) {

    }


}