package com.aleiva.hcompose.ui.heroexplorer.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aleiva.hcompose.data.model.Hero
import com.aleiva.hcompose.ui.heroexplorer.components.informative.NoSearchResults


@Composable
fun HeroList(heroes: List<Hero>, navController: NavController) {
  if (heroes.isEmpty()) {
    NoSearchResults()
    return
  }

  Column (modifier = Modifier.padding(8.dp)) {
    Text(
      text = "Search results (${heroes.size}):",
      fontSize = 20.sp,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(bottom = 16.dp)
    )
    LazyColumn {
      items(heroes) {
          hero -> HeroCard(hero = hero, navController = navController)
      }
    }
  }
}
