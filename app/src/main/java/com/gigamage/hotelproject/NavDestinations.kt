package com.gigamage.hotelproject

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

interface TabDestination {
    val icon: ImageVector
    val route: String
}

object RoomsDestination :TabDestination {
    override val icon: ImageVector = Icons.Filled.Home
    override val route: String = "Rooms"
}

object TasksDestinations : TabDestination{
    override val icon: ImageVector = Icons.Filled.List
    override val route: String = "Tasks"

}

val tabRowScreens = listOf(RoomsDestination, TasksDestinations)