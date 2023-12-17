package com.example.healthscore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.safeContentPadding
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
import androidx.compose.ui.Modifier
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
        modifier=Modifier.safeContentPadding(),
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
                                color = if (currentRoute == it.route) Color(0xFF36B0B8) else Color.LightGray
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = it.icon, contentDescription = null,
                                tint = if (currentRoute == it.route) Color(0xFF36B0B8) else Color.LightGray
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
    ) {it->
        NavigationController(navController = navController)

    }
}