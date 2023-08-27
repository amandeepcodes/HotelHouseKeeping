package com.gigamage.hotelproject

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.gigamage.hotelproject.ui.rooms.AddRoomScreen

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

object AddRoom : TabDestination {
    // Added for simplicity, this icon will not in fact be used, as SingleAccount isn't
    // part of the RallyTabRow selection
    override val icon = Icons.Filled.AddCircle
    override val route: String = "AddRooms"
    val screen: @Composable () -> Unit = { AddRoomScreen() }
}



val tabRowScreens = listOf(RoomsDestination, TasksDestinations)