package com.aleiva.hcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aleiva.hcompose.ui.heroexplorer.activities.HeroBrowser
import com.aleiva.hcompose.ui.heroexplorer.activities.HeroDetail

sealed class Routes(val route: String) {
  object HeroBrowser : Routes("HeroBrowser")
  object HeroDetails : Routes("HeroDetails") {
    const val routeWithArgument = "HeroDetails/{id}"
    const val argument = "id"
    fun passId(id: String): String {
      return "HeroDetails/${id}"
    }
  }
}

@Composable
fun Navigation() {
  val navController = rememberNavController();

  NavHost(
    navController = navController,
    startDestination = Routes.HeroBrowser.route
  ) {

    composable(Routes.HeroBrowser.route) {
      HeroBrowser(navController);
    }

    composable(
      route = Routes.HeroDetails.routeWithArgument,
      arguments = listOf(navArgument(Routes.HeroDetails.argument) { type = NavType.StringType })
    ) { backStackEntry ->
      val id = backStackEntry.arguments?.getString("id") as String
      HeroDetail(id)
    }


  }
}