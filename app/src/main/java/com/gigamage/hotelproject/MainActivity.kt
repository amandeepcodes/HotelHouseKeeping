package com.gigamage.hotelproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gigamage.hotelproject.components.RallyTabRow
import com.gigamage.hotelproject.ui.theme.RallyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RallyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HotelApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelApp(modifier: Modifier = Modifier) {
 val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    var currentDestination = currentBackStack?.destination
    var currentScreen = tabRowScreens.find { it.route == currentDestination?.route } ?: RoomsDestination

    Scaffold(
        topBar = {
            RallyTabRow(allScreens = tabRowScreens,
                onTabSelected ={newScreen -> navController.navigateSingleTopTo(newScreen.route)} ,
                currentScreen = currentScreen)
        }
    ) {
        RallyNavHost(navController = navController,
            modifier = Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RallyTheme {
        HotelApp()
    }
}