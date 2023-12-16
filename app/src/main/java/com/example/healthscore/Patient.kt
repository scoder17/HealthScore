package com.example.healthscore

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.healthscore.patient.AidScreen
import com.example.healthscore.patient.HomeScreen
import com.example.healthscore.patient.MedicineScreen
import com.example.healthscore.patient.ProfileScreen
import com.example.healthscore.patient.VitalsScreen


@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NotificationItem.Home.route)
    {
        composable(route = NotificationItem.Home.route) {
            HomeScreen()
        }
        composable(route = NotificationItem.Medicine.route) {
            MedicineScreen()
        }
        composable(route = NotificationItem.Vitals.route) {
            VitalsScreen()
        }
        composable(route = NotificationItem.Aid.route) {
            AidScreen()
        }
        composable(route = NotificationItem.Profile.route) {
            ProfileScreen()
        }
    }
}
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(){
    val navController = rememberNavController()
    val items = listOf(
        NotificationItem.Home,
        NotificationItem.Medicine,
        NotificationItem.Vitals,
        NotificationItem.Aid,
        NotificationItem.Profile
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo"
                    )
                }
            )
        },
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colorScheme.background) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach {
                    BottomNavigationItem(
                        selected = currentRoute == it.route,
                        label = {
                            Text(
                                text = it.title,
                                color = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = it.icon, contentDescription = null,
                                tint = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                            )
                        },
                        onClick = {
                            if (currentRoute != it.route) {
                                navController.graph.startDestinationRoute?.let {
                                    navController.popBackStack(it, true)
                                }
                                navController.navigate(it.route) {
                                    launchSingleTop = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavigationController(navController = navController)
    }
}




//@Composable
//fun BottomNavBar(){
//    val items = listOf(
//        BottomNavigationItem(
//            title = "Home",
//            selectedIcon = Icons.Filled.Home,
//            unselectedIcon = Icons.Outlined.Home,
//            hasNews = false,
//            badgeCount = null
//        ),
//        BottomNavigationItem(
//            title = "Medicine",
//            selectedIcon = Icons.Filled.Medication,
//            unselectedIcon = Icons.Outlined.Medication,
//            hasNews = false,
//            badgeCount = null
//        ),BottomNavigationItem(
//            title = "Vitals",
//            selectedIcon = Icons.Filled.MonitorHeart,
//            unselectedIcon = Icons.Outlined.MonitorHeart,
//            hasNews = false,
//            badgeCount = null
//        ),BottomNavigationItem(
//            title = "Aid",
//            selectedIcon = Icons.Filled.Newspaper,
//            unselectedIcon = Icons.Outlined.Newspaper,
//            hasNews = false,
//            badgeCount = null
//        ),BottomNavigationItem(
//            title = "Profile",
//            selectedIcon = Icons.Filled.Person,
//            unselectedIcon = Icons.Outlined.Person,
//            hasNews = false,
//            badgeCount = null
//        ),
//    )
//    var selectedItemIndex by rememberSaveable {
//        mutableIntStateOf(0)
//    }
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                    titleContentColor = MaterialTheme.colorScheme.primary,
//                ),
//                title = {
//                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
//            })
//        },
//        bottomBar = {
//            NavigationBar {
//                items.forEachIndexed{
//                    index, item ->
//                    NavigationBarItem(
//                        selected = selectedItemIndex == index,
//                        onClick = { selectedItemIndex=index },
//                        label = {
//                                Text(text = item.title)
//                        },
//                        icon = {
//                            BadgedBox(
//                                badge = {
//                                    if(item.badgeCount != null){
//                                        Badge {
//                                            Text(text = item.badgeCount.toString())
//                                        }
//                                    }
//                                    else if(item.hasNews){
//                                        Badge ()
//                                    }
//                            }) {
//                                Icon(
//                                    imageVector =
//                                    if(index == selectedItemIndex){
//                                                                    item.selectedIcon
//                                                                  }
//                                    else
//                                        item.unselectedIcon,
//                                    contentDescription = item.title
//                                )
//                            }
//                        })
//                }
//            }
//        }
//    ) {
//
//    }
//
//
//}