package com.example.fileshare

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*


class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Build()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Build(){

//        val navigationIndex by remember { mutableStateOf(0)}

        val navController = rememberNavController()

        Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
        ) {
            NavHost(navController = navController, startDestination = NavigationItem.Home.route ){
                composable(NavigationItem.Home.route) {
                    Home()
                }
                composable(NavigationItem.Files.route) {
                    Files()
                }
                composable(NavigationItem.Settings.route) {
                    AppSettings()
                }
            }
        }

    }

    @Composable
    fun BottomNavigationBar(controller: NavController){
        val items = listOf(
            NavigationItem.Home,
                    NavigationItem.Files,
                    NavigationItem.Settings
        )
        val navBackStackEntry by controller.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        BottomNavigation(
            backgroundColor = Color.White,
            elevation = 8.dp
        ) {
            items.forEach { navigationItem ->

                BottomNavigationItem(selected = currentRoute == navigationItem.route,
                    label = {Text(navigationItem.title)},
                    icon = {Icon(navigationItem.icon, contentDescription = "")},
                    alwaysShowLabel = true,
                    selectedContentColor = Color.Blue,
                    onClick = {
                        controller.navigate(navigationItem.route) {
                            controller.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },)
            }
        }
    }
}



sealed class NavigationItem(var route: String, var icon:ImageVector,var title:String){
    object Home: NavigationItem("home",Icons.Rounded.Home, "Home")
    object Files: NavigationItem("files",Icons.Rounded.Download, "Files")
    object Settings: NavigationItem("settings",Icons.Rounded.Settings, "Settings")
}