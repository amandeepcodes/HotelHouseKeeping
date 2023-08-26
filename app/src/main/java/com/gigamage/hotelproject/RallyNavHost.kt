package com.gigamage.hotelproject

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gigamage.hotelproject.ui.tasks.TasksListUI
import com.gigamage.hotelproject.ui.rooms.AddRoomScreen
import com.gigamage.hotelproject.ui.rooms.RoomsList

@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = RoomsDestination.route,
        modifier = modifier
    ) {
        composable(route = RoomsDestination.route) {
            RoomsList(
                onClickAddNewRooms = {
                    navController.navigateToAddRoomScreen()
                }
            )
//            OverviewScreen(
//                onClickSeeAllAccounts = {
//                    navController.navigateSingleTopTo(Accounts.route)
//                },
//                onClickSeeAllBills = {
//                    navController.navigateSingleTopTo(Bills.route)
//                },
//                onAccountClick = { accountType ->
//                    navController.navigateToSingleAccount(accountType)
//                }
//            )
        }
        composable(route = TasksDestinations.route) {
            TasksListUI(onClickAddNewTask = {

            })
//            AccountsScreen(
//                onAccountClick = { accountType ->
//                    navController.navigateToSingleAccount(accountType)
//                }
//            )
        }
//        composable(route = Bills.route) {
//            BillsScreen()
//        }

        composable(route = AddRoom.route) {
            AddRoomScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

private fun NavHostController.navigateToAddRoomScreen() {
    this.navigateSingleTopTo(AddRoom.route)
}