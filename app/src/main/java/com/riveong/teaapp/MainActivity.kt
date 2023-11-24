package com.riveong.teaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.riveong.teaapp.model.Detail
import com.riveong.teaapp.model.SigmasData
import com.riveong.teaapp.model.components.Welcome
import com.riveong.teaapp.model.components.sigmaList
import com.riveong.teaapp.ui.navigation.NavigationItems
import com.riveong.teaapp.ui.navigation.Screen
import com.riveong.teaapp.ui.theme.TeaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeaAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier,navController: NavHostController = rememberNavController(),
) {
    Scaffold(
        bottomBar = {
            botnavbar(navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                Home(navigateToDetail = { sigmaID ->
                    navController.navigate(Screen.DetailSigma.createRoute(sigmaID))
                })
            }
            composable(Screen.AboutMe.route) {
                AboutMe()
            }
            composable(
                route = Screen.DetailSigma.route,
                arguments = listOf(navArgument("sigmaID") { type = NavType.LongType }),
            ){
                val id = it.arguments?.getLong("sigmaID") ?: -1L
                Detail(
                      id
                )
            }
        }
    }


}




@Composable
private fun botnavbar(
    navController: NavHostController,
    modifier: Modifier = Modifier,

){
    NavigationBar(modifier = modifier) {
        val navigationItems = listOf(
            NavigationItems(
                title = "Home",
                icon = ImageVector.vectorResource(R.drawable.home),
                screen = Screen.Home,
                contentDescription = "Menu"
            ),
            NavigationItems(
                title = "About Me",
                icon = ImageVector.vectorResource(R.drawable.aboutme),
                screen = Screen.AboutMe,
                contentDescription = "about_page"
            )

        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = false,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}





@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun GreetingPreview() {
    TeaAppTheme {
        Greeting()
    }
}